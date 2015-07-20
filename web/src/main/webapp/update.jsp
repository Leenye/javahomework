<%@ page import="com.tw.entity.Usr" %>
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

<form action="/web/updateUsr/${usr.id}" method="post">
  <table >

    <tr>
      <td ></td>
      <td>姓名</td>
      <td>性别</td>
      <td>年龄</td>
      <td>邮箱</td>


    </tr>

    <tr>
      <td><input type="text" name="id" value="${usr.id}" hidden ></td>
      <td><input type="text" name="name" value="${usr.name}"></td>
      <td><input type="text" name="gender" value="${usr.gender}"></td>
      <td><input type="text" name="age" value="${usr.age}"></td>
      <td><input type="text" name="email" value="${usr.email}"></td>
      <td><input type="text" name="password" value="${usr.password}" hidden ></td>
      <td><input type="text" name="employeeId" value="${usr.employee.id}" hidden ></td>


    </tr>
  </table>

  <input type="submit" value="确定修改"/>
</form>

</body>
</html>
