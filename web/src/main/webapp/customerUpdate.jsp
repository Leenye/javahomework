<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/web/customer/updateCustomer/${customer.id}" method="post">
  <table >
    <tr>
      <td ></td>
      <td>顾客</td>
    </tr>

    <tr>
      <td><input type="text" name="id" value="${customer.id}" hidden ></td>
      <td><input type="text" name="name" value="${customer.name}"></td>
    </tr>
  </table>
  <input type="submit" value="确定修改"/>
</form>

</body>
</html>
