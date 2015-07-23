<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<form action="/web/employee/updateEmployee/${employee.id}" method="post">
  <table >
    <tr>
      <td ></td>
      <td>姓名</td>
      <td>性别</td>
      <td>年龄</td>
      <td>邮箱</td>
      <td>职位</td>
      <td>状态</td>
    </tr>

    <tr>
      <td><input type="text" name="id" value="${employee.id}" hidden ></td>
      <td><input type="text" name="name" value="${employee.name}"></td>
      <td><input type="text" name="gender" value="${employee.gender}"></td>
      <td><input type="text" name="age" value="${employee.age}"></td>
      <td><input type="text" name="email" value="${employee.email}"></td>
      <td><input type="text" name="role" value="${employee.role}"></td>
      <td><input type="text" name="statement" value="${employee.statement}"></td>
    </tr>
  </table>
  <input type="submit" value="确定修改"/>
</form>


</body>
</html>
