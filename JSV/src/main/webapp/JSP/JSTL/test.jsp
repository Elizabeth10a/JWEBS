<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.eliza.JSP.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>test</title>
</head>
<body>


<%

    List list = new ArrayList<User>();
    list.add(new User(23, "张三", "As"));
    list.add(new User(24, "李四", "Awes"));
    list.add(new User(25, "王五", "Ars"));

    request.setAttribute("list", list);


%>

<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>

    <%--        public int id;
        public String name;
        public String gender;--%>
    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">

        <c:if test="${s.count % 2 != 0}">

            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.getname()}</td>
                <td>${user.getid()}</td>
                <td>${user.getgender()}</td>
            </tr>
        </c:if>

        <c:if test="${s.count % 2 == 0}">

            <tr bgcolor="green">
                <td>${s.count}</td>
                <td>${user.getname()}</td>
                <td>${user.getid()}</td>
                <td>${user.getgender()}</td>
            </tr>
        </c:if>

        <%%>
    </c:forEach>

</table>


</body>
</html>
