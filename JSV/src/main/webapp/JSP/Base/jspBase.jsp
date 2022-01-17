<%@ page contentType="text/html;charset=UTF-8" language="java"
         errorPage="errorPage.jsp" isErrorPage="false" %>
<%--
1. 指令
		* 作用：用于配置JSP页面，导入资源文件
		* 格式：
			<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
--%>

<%--

* 分类：
			1. page		： 配置JSP页面的
				* contentType：等同于response.setContentType()
					1. 设置响应体的mime类型以及字符集
					2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
				* import：导包
				* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面,转发
				* isErrorPage：标识当前也是是否是错误页面。
					* true：是，可以使用内置对象exception
					* false：否。默认值。不可以使用内置对象exception


			2. include	： 页面包含的。导入页面的资源文件
				* <%@include file="top.jsp"%>
			3. taglib	： 导入资源
				* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					* prefix：前缀，自定义的

--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><%--导入标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includePage/included01.jsp" %>
<%-- 此注释 浏览器看不到
    2. 注释:
            1. html注释：
                <!-- -->:只能注释html代码片段
            2. jsp注释：推荐使用
                <%-- --%>：可以注释所有
--%>
<html>
<head>
    <title>Tizxzxtle</title>

</head>
<body>
<%
    int a = 3 / 1;

%>
</body>
</html>