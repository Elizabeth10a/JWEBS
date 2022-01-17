<%--

JSP 内置对象
		* 在jsp页面中不需要创建，直接使用的对象
		* 一共有9个：
				变量名					真实类型						作用
			* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
			* request					HttpServletRequest			一次请求访问的多个资源(转发)
			* session					HttpSession					一次会话的多个请求间
			* application				ServletContext				所有用户间共享数据


			* response					HttpServletResponse			响应对象
			* page						Object						当前页面(Servlet)的对象  this引用
			* out						JspWriter					输出对象，数据输出到页面上
			* config					ServletConfig				Servlet的配置对象
			* exception					Throwable					异常对象（isErrorPage）

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ok", "ok");/*当前页面*/
        pageContext.setAttribute("ok1", "22ok");/*当前页面*/
    %>
</head>
<body>
<%
    System.out.println(pageContext.getAttribute("ok"));
    System.out.println(pageContext.getAttribute("ok1") + "1");
%>
</body>
</html>
