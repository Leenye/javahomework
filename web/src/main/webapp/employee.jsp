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
    <title>雇员信息页面</title>
  <link rel="stylesheet" href="lib/cssUser/table.css">
</head>
<body>

<div class="header">
<h2>雇员信息：</h2>
</div>

<div class="navbar">
  <a href="/web">返回主页</a>
  <a href="/web/user">用户信息</a>
  <a href="/web/course">课程信息</a>
  <a href="/web/schema">课表信息</a>
  <a href="/web/customer">顾客信息</a>
  <a href="/web/login">退出</a>
</div>

<div class="body">
<table border = 1 cellpadding=5>
  <tr>
    <td>ID</td>
    <td>姓名</td>
    <td>性别</td>
    <td>年龄</td>
    <td>邮箱</td>
    <td>角色</td>
    <td>状态</td>
    <td colspan="2">操作</td>
  </tr>
  <c:forEach items="${employees}" var="employee" >
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.gender}</td>
      <td>${employee.age}</td>
      <td>${employee.email}</td>
      <td>${employee.role}</td>
      <td>${employee.statement}</td>

      <td><a href="/web/employee/deleteEmployee/${employee.id}">删除</a></td>
      <td><a href="/web/employee/updateEmployee/${employee.id}">更新</a></td>
    </tr>
  </c:forEach>
</table>

<form action="" method="post">
  <table border="1">
    <tr>
      <td>姓名</td>
      <td>性别</td>
      <td>年龄</td>
      <td>邮箱</td>
      <td>角色</td>
      <td>状态</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td>
        <input type="radio" name="gender" value="M">M
        <input type="radio" name="gender" value="F">F
      </td>
      <td><input type="text" name="age"></td>
      <td><input type="text" name="email"></td>
      <td><input type="text" name="role"></td>
      <td>
        <input type="radio" name="statement" value="ON">ON
        <input type="radio" name="statement" value="OFF">OFF
      </td>
    </tr>
  </table>
  <input type="submit" value="添加雇员"/>
</form>

</div>
</body>
</html>
