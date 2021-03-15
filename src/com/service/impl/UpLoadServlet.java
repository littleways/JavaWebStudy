package com.service.impl;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Littleway
 */
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(req);
                for (FileItem item : fileItems) {
                    if (item.isFormField()){
                        System.out.println("表单项的name属性值：" + item.getFieldName());
                        System.out.println("表单项的value属性值：" + item.getString("utf-8"));
                    }else{
                        System.out.println("表单项的name属性值：" + item.getFieldName());
                        System.out.println("表单项的value属性值：" + item.getName());
                        File file = new File("C:\\" + item.getName());
                        item.write(file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
