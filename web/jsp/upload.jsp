<%--
  Created by IntelliJ IDEA.
  User: Littleway
  Date: 2021/2/3
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
    <base href="http://localhost:81/MyBookShop/">
</head>
<body>
<form action="upLoadServlet" method="post" enctype="multipart/form-data">
    <label>
        <input type="text" name="username">
    </label>
    <br>
    <input type="file" name="upFile"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
