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
    <td>ID</td>
    <td>姓名</td>
    <td>角色</td>
    <td>状态</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${employees}" var="employee" >
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.role}</td>
      <td>${employee.statement}</td>

      <td><a href="/web/employee/deleteEmployee/${employee.id}">删除</a></td>
        <%--<th><a href="/web/update/${time.id}">修改</a></th>--%>
    </tr>
  </c:forEach>
</table>


<form action="" method="post">
  <table border="1">

    <tr>
      <td>姓名</td>
      <td>角色</td>
      <td>状态</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td><input type="text" name="role"></td>
      <td><input type="text" name="statement"></td>
    </tr>
  </table>

  <input type="submit" value="添加雇员"/>
</form>


</body>
</html>
