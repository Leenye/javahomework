<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login.jsp</title>
    <link rel="stylesheet" href="../../lib/cssUser/main.css">
</head>
<body style="text-align: center">
<form action="" method="post">
    <table border="2" cellpadding="4">
        <tr>
        <td>用户名</td>
        <td><input type="text" name="name"/></td>

        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="登陆"/>&nbsp;
                <%--<input type="submit" name="submit" value="注册"/>--%>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
