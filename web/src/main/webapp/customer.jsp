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
</head>
<body>

<table border=1 cellpadding=5>
  <tr>
    <td>姓名</td>
    <td>教练</td>
    <td>操作</td>

  </tr>
  <c:forEach items="${customers}" var="customer">
    <tr>
      <td>${customer.name}</td>
      <td>${customer.employee.name}</td>

      <td><a href="/web/customer/deleteCustomer/${customer.id}">删除</a></td>
      <td><a href="/web/customer/updateCustomer/${customer.id}">修改</a></td>

    </tr>
  </c:forEach>
</table>


<form action="" method="post">
  <table border="1">

    <tr>
      <td>顾客</td>
      <td>教练ID</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td><input type="text" name="coach_id"></td>
    </tr>
  </table>

  <input type="submit" value="添加顾客"/>
</form>



</body>
</html>
