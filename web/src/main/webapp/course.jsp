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
  <meta charset="utf-8">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="lib/cssUser/table.css">
</head>
<body>
<div class="header">
  <h2>课程信息：</h2>
</div>
<div class="navbar">
  <a href="/web">返回主页</a>
  <a href="/web/user">用户信息</a>
  <a href="/web/employee">雇员信息</a>
  <a href="/web/schema">课表信息</a>
  <a href="/web/customer">顾客信息</a>
  <a href="/web/login">退出</a>
</div>

<div class="body" >
<table border="1" cellpadding="5">
  <tr>
    <td>课程</td>
    <td>描述</td>
    <td colspan="2">操作</td>
  </tr>
  <c:forEach items="${courses}" var="course">
    <tr>
      <td>${course.name}</td>
      <td>${course.details}</td>
      <td><a href="/web/course/deleteCourse/${course.id}">删除</a></td>
      <td><a href="/web/course/updateCourse/${course.id}">修改</a></td>
    </tr>
  </c:forEach>
</table>

<form action="" method="post">
  <table border = 1 cellpadding=5>
    <tr>
      <td>课程</td>
      <td>描述</td>
    </tr>

    <tr>
      <td><input type="text" name="name"></td>
      <td><input type="text" name="details"></td>
      <%--<td><input type="date" name="time" id="datepicker">--%>
        <%--<script>--%>
          <%--$( "#datepicker" ).datepicker({minDate:-1, maxDate:"+1M +10D"});--%>
        <%--</script>--%>

      <%--</td>--%>
      <%--<td>--%>
        <%--<select name="coach_id">--%>
          <%--<c:forEach items="${employees}" var="employee">--%>
          <%--<option value="${employee.id}">${employee.name}</option>--%>
          <%--</c:forEach>--%>
        <%--</select>--%>

      <%--</td>--%>
      <%--<td><input type="text" name="employee" hidden></td>--%>

    </tr>
  </table>
  <input type="submit" value="添加课程"/>
</form>

<p>请输入搜索条件</p>
<%--<form action="course/search" method="post">--%>
  <%--<table border="1" cellpadding="5" >--%>

    <%--<tr>--%>
      <%--<td>时间</td>--%>
      <%--<td>教练ID</td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
      <%--<td><input type="text" name="time"></td>--%>
      <%--<td><input type="text" name="coach_id"></td>--%>
    <%--</tr>--%>
  <%--</table>--%>

  <%--<input type="submit" value="提交搜索条件"/>--%>
<%--</form>--%>

<%--<p>搜索结果</p>--%>
<%--<table border = 1 cellpadding=5>--%>
  <%--<tr>--%>
    <%--<th>课程</th>--%>
    <%--<th>时间</th>--%>
    <%--<th>教练</th>--%>
    <%--<th>教练ID</th>--%>

  <%--</tr>--%>
  <%--<c:forEach items="${resultCourse}" var="resultCourse" >--%>
    <%--<tr>--%>
      <%--<td>${resultCourse.name}</td>--%>
      <%--<td>${resultCourse.time}</td>--%>
      <%--<td>${resultCourse.employee.name}</td>--%>
      <%--<td>${resultCourse.employee.id}</td>--%>

    <%--</tr>--%>
  <%--</c:forEach>--%>
<%--</table>--%>
</div>

</body>
</html>
