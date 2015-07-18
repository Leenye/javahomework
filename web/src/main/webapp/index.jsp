<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户信息显示</title>
</head>
<body>

<a href="/web/login">退出</a>

<h2>系统用户信息：</h2>

<table border = 1 cellpadding=5>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>邮箱</th>
        <td>职称</td>
    </tr>
<c:forEach items="${usrs}" var="user" >
    <tr>
        <td>${user.name}</td>
        <td>${user.gender}</td>
        <td>${user.age}</td>
        <td>${user.email}</td>
        <td>${user.role}</td>

        <td><a href="/web/deleteUsr/${user.id}">删除</a></td>
        <th><a href="/web/updateUsr/${user.id}">修改</a></th>

    </tr>
</c:forEach>
</table>


<form action="" method="post" style.display="none">
    <table border="1">

        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>邮箱</td>
            <td>密码</td>
            <td>职称</td>
            <td>状态</td>
        </tr>

        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="gender"></td>
            <td><input type="text" name="age" ></td>
            <td><input type="text" name="email"></td>
            <td><input type="text" name="password"></td>
            <td><input type="text" name="role"></td>
            <td><input type="text" name="statement"></td>

        </tr>
    </table>

    <input type="submit" value="添加系统用户"/>
</form>

<a href="/course">课程信息</a>
<a href="/web/courseTime">课表信息</a>
<a href="/web/customer">顾客信息</a>




</body>
</html>