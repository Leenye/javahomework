<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/19/15
  Time: 6:52 PM
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
    <td>课程</td>
    <td>教练</td>
    <td>操作</td>

  </tr>
  <c:forEach items="${courses}" var="course">
    <tr>
      <td>${course.course_name}</td>
      <td>${course.employee.employee_id}</td>
      <td><a href="/web/course/${course.employee.employee_id}">删除</a></td>
    </tr>
  </c:forEach>

</table>

</body>
</html>
