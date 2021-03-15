package com.service.impl;

import com.enumType.enums.REGISTER_ERROR_CORD;
import com.service.UserManager;
import com.utils.NamedThreadFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author Littleway
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("username", "1");
        cookie.setMaxAge(120);
        resp.addCookie(cookie);
        int retCode = UserManager.getInstance().checkLoginInfo(req.getParameter("username"), req.getParameter("passowrd"));
        if (retCode != REGISTER_ERROR_CORD.SUCCESS.ordinal()) {
            resp.sendRedirect("pages/user/login_error.html");
        } else {
            resp.setIntHeader("loginState", 1);
            resp.sendRedirect("pages/user/login_success.html");
        }

        ScheduledExecutorService timer = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("测试定时器"));
        timer.scheduleAtFixedRate(() -> {
            //定时器实际执行内容
            System.out.println("11111111111111" + Thread.currentThread().getName());
        }, 1000L,10000L,TimeUnit.MILLISECONDS);
    }
}
