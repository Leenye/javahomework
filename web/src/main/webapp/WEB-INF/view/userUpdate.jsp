<%@ page import="com.tw.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/9/15
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息修改页面</title>
</head>
<body>

<form action="/web/user/updateUser/${user.id}" method="post">
  <table >
    <tr>
      <td ></td>
      <td>姓名</td>
      <td>邮箱</td>
    </tr>
    <tr>
      <td><input type="text" name="id" value="${user.id}" hidden ></td>
      <td><input type="text" name="name" value="${user.name}"></td>
      <td><input type="text" name="password" value="${user.password}" hidden ></td>
      <td><input type="text" name="employee_id" value="${user.employee.id}" hidden ></td>
    </tr>
  </table>
  <input type="submit" value="确定修改"/>
</form>

</body>
</html>
