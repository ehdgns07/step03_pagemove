<%--
  Created by IntelliJ IDEA.
  User: liverbird
  Date: 2022/09/19
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sucess</title>
</head>
<body>
    <h2>${Company} 회원 가입 성공!</h2>
    <%= request.getParameter("id") %>
</body>
</html>
