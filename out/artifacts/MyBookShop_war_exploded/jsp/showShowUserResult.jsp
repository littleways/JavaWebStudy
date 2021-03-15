<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Littleway
  Date: 2021/2/1
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>查询结果</title>
    <base href="http://localhost:81/MyBookShop/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
</head>
<body>
<%
    @SuppressWarnings("unchecked")
    List<User> userList = (List<User>) request.getAttribute("userList");
    pageContext.setAttribute("userList", userList);
%>
<br>
<form action="searchUserServlet" align="center">
    <label><input type="text" name="searchKey"></label>
    <input type="submit" value="搜索">

</form>
<br>
<table class="searchTable">
    <c:if test="${pageScope.userList.size() <= 0}">
            <h2 class="noResult">无搜索结果!</h2>
    </c:if>
    <c:if test="${pageScope.userList.size() > 0}">
        <td class="titleInfo">UID</td>
        <td class="titleInfo">用户名</td>
        <td class="titleInfo">密码</td>
        <td class="titleInfo">邮件</td>
        <br>
        <c:forEach items="${pageScope.userList}" var="user">
            <tr>
                <td class="userInfo">${user.userid}</td>
                <td class="userInfo">${user.username}</td>
                <td class="userInfo">${user.password}</td>
                <td class="userInfo">${user.email}</td>
            </tr>
        </c:forEach>
    </c:if>


    <%--    <%--%>
    <%--        for (User user : userList) {--%>
    <%--            pageContext.setAttribute("user", user);--%>
    <%--    %>--%>
    <%--    <tr>--%>
    <%--        <td class="userInfo">${user.userid}${user.username}</td>--%>
    <%--        <td class="userInfo">${user.username}</td>--%>
    <%--        <td class="userInfo">${user.password}</td>--%>
    <%--        <td class="userInfo">${user.email}</td>--%>
    <%--    </tr>--%>
    <%--    <%--%>
    <%--        }--%>
    <%--    %>--%>
</table>
</body>
</html>
