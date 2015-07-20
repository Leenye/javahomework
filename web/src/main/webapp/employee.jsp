<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/19/15
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>雇员信息：</h2>

<table border = 1 cellpadding=5>
  <tr>
  <td>角色</td>
  <td>用户ID</td>
  <td>操作</td>

  </tr>
  <c:forEach items="${employees}" var="employee" >
    <tr>
      <td>${employee.role}</td>
      <td>${employee.usr.id}</td>

      <td><a href="/web/employee/${employee.usr.id}">删除</a></td>
        <%--<th><a href="/web/update/${time.id}">修改</a></th>--%>
    </tr>
  </c:forEach>
</table>



</body>
</html>
