<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="../../lib/css/bootstrap.css">
</head>
<body>
<div class="header">
  <h3>顾客信息：</h3>
</div>

<div class="navbar-brand">
  <a href="/web">返回主页</a>
  <a href="/web/user">用户信息</a>
  <a href="/web/employee">雇员信息</a>
  <a href="/web/course">课程信息</a>
  <a href="/web/schema">课表信息</a>
  <a href="/web/login">退出</a>
</div>

<div class="table table-bordered">
<table class="table table-bordered" >
  <tr>
    <td>姓名</td>
    <td colspan="2">操作</td>
  </tr>
  <c:forEach items="${customers}" var="customer">
    <tr>
      <td>${customer.name}</td>
      <td><a href="/web/customer/deleteCustomer/${customer.id}">删除</a></td>
      <td><a href="/web/customer/updateCustomer/${customer.id}">修改</a></td>
    </tr>
  </c:forEach>
</table>


<form class="form-group" action="" method="post">
  <table border="1">
    <tr>
      <td>顾客</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
    </tr>
  </table>
  <input type="submit" value="添加顾客"/>
</form>

</div>

</body>
</html>
