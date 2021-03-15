package com.service.impl;

import com.bean.User;
import com.service.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Littleway
 */
public class SearchUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchKey = req.getParameter("searchKey");
        List<User> userList = UserManager.getInstance().serchUser(searchKey);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/jsp/showShowUserResult.jsp").forward(req,resp);
    }
}
