<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/21/15
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<form action="/web/course/updateCourse/${course.id}" method="post">
  <table >
    <tr>
      <td ></td>
      <td>课程</td>
      <td>描述</td>
    </tr>
    <tr>
      <td><input type="text" name="id" value="${course.id}" hidden ></td>
      <td><input type="text" name="name" value="${course.name}"></td>
      <td><input type="text" name="details" value="${course.details}"></td>
      <%--<td>--%>
        <%--<select name="coach_id">--%>
          <%--<c:forEach items="${employees}" var="employee">--%>
            <%--<option value="${employee.id}">${employee.name}</option>--%>
          <%--</c:forEach>--%>
        <%--</select>--%>

      <%--</td>--%>

    </tr>
  </table>
  <input type="submit" value="确定修改"/>
</form>

</body>
</html>
