package com.service.impl;

import com.enumType.enums.REGISTER_ERROR_CORD;
import com.service.UserManager;
import com.utils.RandomUtils;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户注册
 * @author Littleway
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        int retCode = UserManager.getInstance().checkRegisterInfo(parameterMap);

        if (retCode != REGISTER_ERROR_CORD.SUCCESS.ordinal()) {
            resp.sendRedirect("jsp/error_page.jsp");
        } else {

            UserManager.getInstance().registUser(RandomUtils.getGUID(), req.getParameter("username"), req.getParameter("password"), req.getParameter("email"));
            resp.sendRedirect("pages/user/register_success.html");
        }
    }

}
