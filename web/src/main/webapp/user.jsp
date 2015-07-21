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
    <title></title>
</head>
<body>

<h2>系统用户信息：</h2>

<table border = 1 cellpadding=5>
  <tr>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    <th>邮箱</th>
    <th>工号</th>

  </tr>
  <c:forEach items="${usrs}" var="user" >
    <tr>
      <td>${user.name}</td>
      <td>${user.gender}</td>
      <td>${user.age}</td>
      <td>${user.email}</td>
      <td>${user.employee.id}</td>

      <td><a href="/web/user/deleteUsr/${user.id}">删除</a></td>
      <th><a href="/web/user/updateUsr/${user.id}">修改</a></th>

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
      <td>密码</td>
      <td>工号</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td><input type="text" name="gender"></td>
      <td><input type="text" name="age" ></td>
      <td><input type="text" name="email"></td>
      <td><input type="text" name="password"></td>
      <td><input type="text" name="employee_id"></td>

    </tr>
  </table>

  <input type="submit" value="添加系统用户"/>
</form>

<a href="/web">返回主页</a>



</body>
</html>
