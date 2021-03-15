package com.service.impl;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Littleway
 */
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dlstr = "upload.jsp";
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/jsp/" + dlstr);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(dlstr , StandardCharsets.UTF_8.toString()));
        InputStream resourceAsStream = servletContext.getResourceAsStream("/jsp/" + dlstr);
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
        resp.flushBuffer();
        resourceAsStream.close();
    }
}