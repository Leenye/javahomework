<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/23/15
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/web/schema/updateSchema/${schema.id}" method="post">
  <table >
    <tr>
      <td ></td>
      <td>课程</td>
      <td>教练</td>
      <td>时间</td>
      <td>学员</td>
    </tr>

    <tr>
      <td><input type="text" name="id" value="${schema.id}" hidden ></td>
      <td>
      <select name="course_id">
      <c:forEach items="${courses}" var="course">
      <option value="${course.id}">${course.name}</option>
      </c:forEach>
      </select>
      </td>

      <td>
      <select name="coach_id">
      <c:forEach items="${employees}" var="employee">
      <option value="${employee.id}">${employee.name}</option>
      </c:forEach>
      </select>
      </td>
      <td><input type="date" name="time" value="${schema.time}"></td>
      <td><input type="text" name="customer" value="${schema.customer}"></td>
    </tr>
  </table>
  <input type="submit" value="确定修改"/>
</form>


</body>
</html>
