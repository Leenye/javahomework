<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户页面</title>
  <link rel="stylesheet" href="lib/cssUser/table.css">

</head>
<body>
<div class="header">
<h2>系统用户信息：</h2>
</div>

<div class="navbar">
  <a href="/web">返回主页</a>
  <a href="/web/employee">雇员信息</a>
  <a href="/web/course">课程信息</a>
  <a href="/web/schema">课表信息</a>
  <a href="/web/customer">顾客信息</a>
  <a href="/web/login">退出</a>
</div>

<div class="body">
<table border = 1 cellpadding=5>
  <tr>
    <th>姓名</th>
    <th>工号</th>
    <th colspan="2">操作</th>
  </tr>
  <c:forEach items="${users}" var="user" >
    <tr>
      <td>${user.name}</td>
      <td>${user.employee.id}</td>
      <td><a href="/web/user/deleteUser/${user.id}">删除</a></td>
      <th><a href="/web/user/updateUser/${user.id}">修改</a></th>
    </tr>
  </c:forEach>
</table>

<form action="" method="post">
  <table border="1">
    <tr>
      <td>姓名</td>
      <td>密码</td>
      <td>工号</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td><input type="text" name="password"></td>
      <td><input type="text" name="employee_id"></td>
    </tr>
  </table>
  <input type="submit" value="添加系统用户"/>
</form>
</div>


</body>
</html>
