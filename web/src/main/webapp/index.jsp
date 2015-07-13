
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户信息显示</title>
</head>
<body>

<h2>用户基本信息：</h2>

<table border = 1 cellpadding=5>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>邮箱</th>
    </tr>
<c:forEach items="${usrs}" var="user" >
    <tr>
        <td>${user.name}</td>
        <td>${user.gender}</td>
        <td>${user.age}</td>
        <td>${user.email}</td>
        <td><a href="/web/deleteUsr?id=${user.id}">删除</a></td>
        <th><a href="/web/updateUsr?id=${user.id}">修改</a></th>

    </tr>
</c:forEach>
</table>


<form action="/web" method="post">
    <table border="1">

        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>邮箱</td>
        </tr>

        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="gender"></td>
            <td><input type="text" name="age" ></td>
            <td><input type="text" name="email"></td>
        </tr>
    </table>

    <input type="submit" value="添加数据"/>
</form>

</body>
</html>