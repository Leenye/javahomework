<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login.jsp</title>
        <p>如果有已注册请直接登录</p>
        <p>如果没有注册请直接注册</p>
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
            <td><input type="text" name="password"></td>
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
