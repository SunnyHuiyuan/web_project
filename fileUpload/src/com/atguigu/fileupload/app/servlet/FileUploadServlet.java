package com.atguigu.fileupload.app.servlet;

import com.atguigu.fileupload.app.utils.FileUploadAppProperties;
import com.atguigu.fileupload.beans.FileUploadBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/app/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {

    private static final String FILE_PATH = "E:\\files";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletFileUpload upload = getServletFileUpload();

        try {

            //把需要上传的FileItem都放入到该Map中
            //键：文件的待存放路径   值：对应的FileItem对象
            Map<String, FileItem> uploadFiles = new HashMap<>();

            //解析请求，得到FileItem的集合
            // FileItem 里面包含文本域，和文件域，用 isFormField() 方法来判断。此处的items=6
            List<FileItem> items = upload.parseRequest(request);

            //1.构建FileUploadBean的集合,同时填充uploadFiles, FileUploadBean用于在数据库中记录
            List<FileUploadBean> beans = buildFileUploadBeans(items, uploadFiles);

            //2.校验扩展名：
            vaidateExtName(beans);

            //3.校验文件的大小：在解析时已经校验了，我们只需要通过异常得到结果。

            //4.进行文件的上传操作
            System.out.println(uploadFiles.size());
            upload(uploadFiles);

            //5.把上传的信息保存到数据库中
            saveBeans(beans);


        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    private void saveBeans(List<FileUploadBean> beans) {
    }


    /**
     * 文件上传前的准备工作，得到filePath和InputStream
     *
     * @param uploadFiles
     * @throws IOException
     */
    private void upload(Map<String, FileItem> uploadFiles) throws IOException {
        for (Map.Entry<String, FileItem> uploadFile : uploadFiles.entrySet()) {
            String filePath = uploadFile.getKey();
            FileItem item = uploadFile.getValue();

            upload(filePath, item.getInputStream());
        }
    }

    /**
     * 文件上传的IO方法
     *
     * @param filePath
     * @param inputStream
     * @throws IOException
     */
    private void upload(String filePath, InputStream inputStream) throws IOException {
        OutputStream out = new FileOutputStream(filePath);

        byte[] buffer = new byte[1024];
        int len = 0;

        while ((len = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        inputStream.close();
        out.close();

        System.out.println(filePath);
    }

    private void vaidateExtName(List<FileUploadBean> beans) {
    }

    /**
     * 利用传入的FileItem的集合构建FileUploadBean的集合,同时填充uploadFiles
     * FileUploadBean对象封装了：id,fileName,filePath,fileDesc
     * uploadFiles:Map<String, FileItem>类型，存放文件域类型的FileItem。键：文件的待存放路径  值：对应的FileItem对象
     * <p>
     * 构建过程：
     * 1.对传入FileItem的集合进行遍历，得到desc的那个Map.键：desc的fileName(desc1,desc2...).
     * 值：desc的那个输入的文本值
     * <p>
     * 2.对传入FileItem的集合进行遍历，得到文件域的那些FileItem对象，构建对应的key(desc1,desc2...)来获取其desc
     * 构建的FileUploadBean对象，并填充beans和uploadFiles
     *
     * @param items
     * @param uploadFiles
     * @return
     */
    private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) {

        List<FileUploadBean> beans = new ArrayList<>();

        //1.遍历FileItem的集合，先得到desc的Map<String,String>,其中键：fieldName(desc1,desc2...)
        //值：表单域对应字段的值
        Map<String, String> descs = new HashMap<>();

        for (FileItem item : items) {
            if (item.isFormField()) {
                descs.put(item.getFieldName(), item.getString());
            }
        }

        //2.再遍历FileItem集合，得到文件域的FileItem对象
        //每得到一个FileItem对象都创建一个FileUploadBean对象
        //得到 fileName,构建 filePath ，从1的Map中得到当前FileItem对应的那个desc.
        //使用fieldName后面的数字去匹配。
        for (FileItem item : items) {
            if (!item.isFormField()) {
                String fieldName = item.getFieldName();
                String index = fieldName.substring(fieldName.length() - 1);

                //得到fileName
                String fileName = item.getName();
                //得到desc
                String desc = descs.get("desc" + index);
                //通过getFilePath()得到filePath
                String filePath = getFilePath(fileName);

                FileUploadBean bean = new FileUploadBean(fileName, filePath, desc);
                beans.add(bean);

                uploadFiles.put(filePath, item);
            }
        }
        return beans;
    }

    /**
     * 根据给定的文件名构建一个随机的文件名
     * 1.构建的文件的文件名的扩展名和给定的文件的扩展名一致
     * 2.利用了Random和当前的系统时间构建随机的文件的名字
     *
     * @param fileName
     * @return
     */
    private String getFilePath(String fileName) {
        String extName = fileName.substring(fileName.lastIndexOf("."));
        Random random = new Random();
        int randomNum = random.nextInt(100000);
        String filePath = FILE_PATH + "\\" + System.currentTimeMillis() + randomNum + extName;
        return filePath;
    }

    /**
     * 构建ServletFileUpload对象
     * 从配置文件中读取了部分属性，用户设置约束
     * 该方法代码基本来源于以下两个 .jar 文档：
     * commons-fileupload-1.2.1.jar
     * commons-io-2.0.jar
     *
     * @return upload
     */
    private ServletFileUpload getServletFileUpload() {
        //得到属性文件里面的各个值
        String ext = FileUploadAppProperties.getInstance().getProperties("exts");
        String fileMaxSize = FileUploadAppProperties.getInstance().getProperties("file.max.size");
        String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperties("total.file.max.size");

        DiskFileItemFactory factory = new DiskFileItemFactory();

        //设置内存中最多可以存放的上传文件的大小, 若超出则把文件写到一个临时文件夹中. 以 byte 为单位
        factory.setSizeThreshold(1024 * 500);
        //设置那个临时文件夹
        File tempDirectory = new File("E:\\tempDirectory");
        factory.setRepository(tempDirectory);

        ServletFileUpload upload = new ServletFileUpload(factory);

        //设置上传文件的总的大小. 也可以设置单个文件的大小.
        //单个
        upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
        //总的
        upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
        return upload;
    }
}
