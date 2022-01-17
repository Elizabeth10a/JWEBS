<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.eliza.JSP.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--

/*
*
*
* ## MVC：开发模式
	1. jsp演变历史
		1. 早期只有servlet，只能使用response输出标签数据，非常麻烦
		2. 后来又jsp，简化了Servlet的开发，如果过度使用jsp，在jsp中即写大量的java代码，有写html表，造成难于维护，难于分工协作
		3. 再后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理性

	2. MVC：
		1. M：Model，模型。JavaBean
			* 完成具体的业务操作，如：查询数据库，封装对象
		2. V：View，视图。JSP
			* 展示数据
		3. C：Controller，控制器。Servlet
			* 获取用户的输入
			* 调用模型
			* 将数据交给视图进行展示


		* 优缺点：
			1. 优点：
				1. 耦合性低，方便维护，可以利于分工协作
				2. 重用性高

			2. 缺点：
				1. 使得项目架构变得复杂，对开发人员要求高



--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--默认是false 不忽略--%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            width: 1000px;
            /*设置居中*/
            margin: 0 auto;
            border: 1px solid black;
            border-spacing: 12px
        }
    </style>
</head>
<body>
<%--
## EL表达式
	1. 概念：Expression Language 表达式语言
	2. 作用：替换和简化jsp页面中java代码的编写
	3. 语法：${表达式}
	4. 注意：
		* jsp默认支持el表达式的。如果要忽略el表达式
			1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
			2. \${表达式} ：忽略当前这个el表达式


	5. 使用：
		1. 运算：
			* 运算符：
				1. 算数运算符： + - * /(div) %(mod)
				2. 比较运算符： > < >= <= == !=
				3. 逻辑运算符： &&(and) ||(or) !(not)
				4. 空运算符： empty
					* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
					* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
					* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0

					--%>

<%--EL 表达式  \ 单条语句忽略解析 --%>
${3>4}<br>
\${3>4}
<table border="1">
    <tr>
        <td>${3 div 2} </td>
        <td>${3 mod 2} </td>
        <td>${3>4&&5<54} </td>
    </tr>

    <%--
    2. 获取值
        1. el表达式只能从域对象中获取值
        2. 语法：
            1. ${域名称.键名}：从指定域中获取指定键的值
            * 域名称：
                1. pageScope		--> pageContext
                2. requestScope 	--> request
                3. sessionScope 	--> session
                4. applicationScope --> application（ServletContext）
            * 举例：在request域中存储了name=张三
            * 获取：${requestScope.name}

            2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。

    --%>
    <tr>
        <td>设置信息:</td>
        <td> request.setAttribute:</td>
        <% request.setAttribute("张三", "法外狂徒"); %>
        <% session.setAttribute("张三", "法外狂徒二号"); %>
        <td>session.setAttribute:</td>
        <% session.setAttribute("age", "12");%>


    </tr>
    <tr>
        <td>域名获取信息:</td>

        <td>requestScope.张三：${requestScope.张三}</td>
        <%--没有值为: ""--%>
        <td>sessionScope.age:${sessionScope.age}</td>


    </tr>
    <tr>        <%--   ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。--%>

        <td>直接获取信息:</td>

        <td>${张三 }</td>
        <%--没有值为: ""--%>
        <td>${age}</td>


    </tr>
</table>

<%--

3. 获取对象、List集合、Map集合的值
    1. 对象：${域名称.键名.属性名}
        * 本质上会去调用对象的getter方法

    2. List集合：${域名称.键名[索引]}

    3. Map集合：
        * ${域名称.键名.key名称}
        * ${域名称.键名["key名称"]}


3. 隐式对象：
    * el表达式中有11个隐式对象
    * pageContext：
    * 获取jsp其他八个内置对象
    * ${pageContext.request.contextPath}：动态获取虚拟目录



--%>
<table border="1">

    <tr>
        <%--
    * 通过的是对象的属性来获取
        * setter或getter方法，去掉set或get，在将剩余部分，首字母变为小写。
        * setname --> name --> name
--%>

        <td>设置信息：存储对象</td>

        <% User user = new User(12, "张三", "12");
            request.setAttribute("user01", user);
        %><%
        User user01 = (User) request.getAttribute("user01");
    %>

        <td> ${requestScope.user01}</td>
        <td> ${requestScope.user01.toString()}</td>
        <td> ${requestScope.user01.toString()}</td>

    </tr>
    <tr>
        <%
            List list = new ArrayList();
            list.add("as");
            list.add("bs");
            list.add(user01);
            request.setAttribute("list", list);
        %>

        <td>获取list</td>
        <td>${requestScope.list}</td>
        <td>${list[0]}</td>
        <td>${list[2].toString()} </td>
        <%--没有为空--%>
        <h4>{not empty list}${not empty  list}</h4>

    </tr>
    <tr>
        <%
            Map map = new HashMap();
            map.put("sname", "李四");
            map.put("gender", "男");
            map.put("user", user01);

            request.setAttribute("map", map);
        %>
        <td>获取Map</td>
        <td> ${map.sname}</td>

        <td> ${map["gender"]}</td>
        <td> ${map.user.toString()}</td>
        <h4>{empty map}${empty  map}</h4>
    </tr>
</table>

</body>
</html>
