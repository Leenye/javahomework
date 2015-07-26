<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>课程表页面</title>
</head>
<body>
  <div class="navbar">
    <a href="/web">返回主页</a>
    <a href="/web/user">用户信息</a>
    <a href="/web/employee">雇员信息</a>
    <a href="/web/course">课程信息</a>
    <a href="/web/customer">顾客信息</a>
    <a href="/web/login">退出</a>
  </div>
  <div class="header">
    <h2>课程表信息：</h2>
  </div>
  <div class="body">
    <form id="updateSchema" >
      <table>
        <tr>
          <td></td>
          <td>课程</td>
          <td>教练</td>
          <td>时间</td>
          <td>学员</td>
        </tr>

        <tr>
          <td></td>
          <td>${schema.name}</td>
          <td>${schema.employee.name}</td>
          <td>${schema.time}</td>
          <td>${schema.customer}</td>
        </tr>

        <tr>
          <td><input type="text" name="id" value="${schema.id}" hidden></td>
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
    <table border="1" cellpadding="5">
      <tr>
        <td>课程</td>
        <td>教练</td>
        <td>时间</td>
        <td>学员</td>
        <td colspan="2">操作</td>
      </tr>
      <c:forEach items="${schemas}" var="schema">
        <tr>
          <td>${schema.course.name}</td>
          <td>${schema.employee.name}</td>
          <td>${schema.time}</td>
          <td>${schema.customer}</td>
          <td>
            <button class="delete_button" id="${schema.id}">删除</button>
          </td>
          <td>
            <button class="update_button" id="${schema.id}">修改</button>
          </td>


        </tr>
      </c:forEach>
    </table>
    <form id="addSchema" method="post">
      <table border=1 cellpadding=5>
        <tr>
          <td>课程</td>
          <td>教练</td>
          <td>时间</td>
          <td>学员</td>
          <td></td>
        </tr>
        <tr>
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
          <td>
            <input type="date" name="time" min="now" id="datepicker">
          </td>
          <td>
            <input type="text" name="customer">
          </td>
        </tr>
      </table>
      <input type="submit" value="添加课程"/>
    </form>
  </div>
  <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
  <spring:url value="/lib/js/schema.js" var="schemaJs"/>
  <script src="${jquery}"></script>
  <script src="${schemaJs}"></script>
</body>
</html>
