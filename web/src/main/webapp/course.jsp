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
    <td>时间</td>
    <td>教练</td>
    <td>操作</td>

  </tr>
  <c:forEach items="${courses}" var="course">
    <tr>
      <td>${course.name}</td>
      <td>${course.time}</td>
      <td>${course.employee.name}</td>

      <td><a href="/web/course/deleteCourse/${course.id}">删除</a></td>
      <td><a href="/web/course/updateCourse/${course.id}">修改</a></td>

    </tr>
  </c:forEach>
</table>


<form action="" method="post">
  <table border="1">

    <tr>
      <td>课程</td>
      <td>时间</td>
      <td>教练ID</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td><input type="text" name="time"></td>
      <td><input type="text" name="coach_id"></td>
    </tr>
  </table>

  <input type="submit" value="添加课程"/>
</form>

<a href="/web">返回主页</a>


</body>
</html>
