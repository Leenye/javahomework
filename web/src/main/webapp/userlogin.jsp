<%@ page language="java" contentType="text/html;charset=gb2312" %>
<html>
<head>
    <title>Login.jsp</title>
</head>
<body style="text-align: center">
<form action="UserServlet" method="post">
    <table border="2" cellpadding="4">
        </tr>
        <p>�������ע����ֱ�ӵ�¼</p>
        <p>���û��ע����ֱ��ע��</p>
        </tr>

        </tr>
        <td>�û���</td>
        <td><input type="text" name="uname"/></td>

        </tr>
        <tr>
            <td>����:</td>
            <td><input type="text" name="upass"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" name="submit" value="��½"/>&nbsp;
                <%--<input type="submit" name="submit" value="ע��"/>--%>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
