package com.atguigu.fileupload.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = "/uploadServlet")
public class UploadServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        无法再使用getParameter方法来获取file或者describe的值

        //1.获取请求信息
        String file = request.getParameter("file");
        String describe = request.getParameter("describe");

        System.out.println(file);
        System.out.println(describe);
        */

        /*
        可以使用输入流的方式来获取.但不建议这样做.因为太麻烦

        InputStream in = request.getInputStream();

        Reader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String str = null;

        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        */

        /**
         *1.得到FileItem的集合
         */
        //----> 复杂的方式: 可以为文件的上传加入一些限制条件和其他的属性
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //设置内存中最多可以存放的上传文件的大小, 若超出则把文件写到一个临时文件夹中. 以 byte 为单位
        factory.setSizeThreshold(1024 * 500);
        //设置那个临时文件夹
        File tempDirectory = new File("E:\\tempDirectory");
        factory.setRepository(tempDirectory);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        //设置上传文件的总的大小. 也可以设置单个文件的大小.
        upload.setSizeMax(1024 * 1024 * 5);

        // Parse the request
        try {
            List<FileItem> /* FileItem */ items = upload.parseRequest(request);
            //2.遍历items:
            for (FileItem item : items) {
                // 若是一个一般的表单域，打印信息；
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();

                    System.out.println(name + ": " + value);
                }
                //若是文件域则保存到E:\files目录下
                else {
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    boolean isInMemory = item.isInMemory();
                    long sizeInBytes = item.getSize();

                    System.out.println("fieldName:      " + fieldName);
                    System.out.println("fileName:       " + fileName);
                    System.out.println("contenType:     " + contentType);
                    System.out.println("isInMemory:     " + isInMemory);
                    System.out.println("sizeInBytes:    " + sizeInBytes);

                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;

                    fileName = "E:\\files\\" + fileName;
                    System.out.println(fileName);

                    OutputStream out = new FileOutputStream(fileName);

                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }

                    out.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
