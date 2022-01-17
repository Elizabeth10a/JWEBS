<%--
  Created by IntelliJ IDEA.
  User: lubu
  Date: 10/20/21
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/JSV_war_exploded/getParameter" method="post">
    <input type="text" placeholder="请输入用户名" name="username"><br>
    <input type="text" placeholder="请输入密码" name="password"><br>

    <input type="checkbox" name="hobby" placeholder="ASS" value="game">游戏
    <input type="checkbox" name="hobby" value="study">学习
    <br>

    <input type="submit" value="注册">

</form>
</body>
</html>
