package com.atguigu.filedownload.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "FileDownloadServlet", urlPatterns = "/downloadServlet")
public class FileDownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 7528572087363553792L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/x-msdownload");

        String fileName = "文件下载.pptx";
        response.setHeader("Content-Disposition", "attachment;filename="
                + URLEncoder.encode(fileName, "UTF-8"));

        OutputStream out = response.getOutputStream();
        String pptFileName = "E:\\files\\文件下载流案例\\download.pptx";

        InputStream in = new FileInputStream(pptFileName);

        byte[] buffer = new byte[1024];
        int len = 0;

        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }

        in.close();
    }
}
