<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 7/13/15
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<%
  if (session.getAttribute("userinfo") == null) {
%>
<script type="text/javascript" language="javascript">
  alert("您还没有登录，请登录...");
  window.document.location.href = "userlogin.html";
</script>
<%
  }
%>

</body>
</html>
