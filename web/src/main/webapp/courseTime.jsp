<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/18/15
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
</head>
<body>
<h2>课程表时间信息：</h2>

<table border = 1 cellpadding=5>
    <td>时间</td>
    <td>操作</td>

  </tr>
  <c:forEach items="${time}" var="time" >
    <tr>
      <td>${time.course_time}</td>
      <td><a href="/web/courseTime/${time.time_id}">删除</a></td>
      <%--<th><a href="/web/update/${time.id}">修改</a></th>--%>
    </tr>
  </c:forEach>
</table>

<form action="" method="post">
  <table border="1",cellpadding="5">

    <tr>
      <td>时间</td>
    </tr>

    <tr>
      <td><input type="text" name="time"></td>
    </tr>
  </table>
  <input type="submit" value="增加时间"/>
</form>



<table border = 1 cellpadding=5>
  <td>课程</td>
  <td>操作</td>

  </tr>
  <c:forEach items="${time}" var="time" >
    <tr>
      <td>${time.course_time}</td>
      <td><a href="/web/courseTime/${time.time_id}">删除</a></td>
        <%--<th><a href="/web/update/${time.id}">修改</a></th>--%>
    </tr>
  </c:forEach>
</table>


</body>
</html>
