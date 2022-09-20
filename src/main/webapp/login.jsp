<%--
  Created by IntelliJ IDEA.
  User: liverbird
  Date: 2022/09/19
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>로그인</h2>
<form action="/loginCheck" method="post">
    id : <input type="text" name="id"/>
    pwd : <input type="password" name="pwd"/>
    <input type="submit" value="로그인">
</form>
</body>
</html>
