<%--
  Created by IntelliJ IDEA.
  User: Littleway
  Date: 2021/2/1
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<table>
    <%
        for (int i = 1; i < 10; i++) {
    %>
    <tr>
        <%
            for (int j = 1; j < i + 1; j++) {
        %>
        <td><%=j%>x<%=i%>=<%=i * j%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
