package com.eliza.JspSC.CookieSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/27/21
 * @Software: IntelliJ IDEA
 */

/*
*
*

	4. 细节：
		1. 当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
			* 默认情况下。不是。(客户端关闭意味着会话结束)
			* 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
				 Cookie c = new Cookie("JSESSIONID",session.getId());
		         c.setMaxAge(60*60);
		         response.addCookie(c);

		2. 客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
			* 不是同一个，但是要确保数据不丢失。tomcat自动完成以下工作
				* session的钝化：
					* 在服务器正常关闭之前，将session对象系列化到硬盘上
					*tomcat--> apache-tomcat/work/ SESSION.ser
					* idea 启动是会先删除该目录，重现创建
				* session的活化：
					* 在服务器启动后，将session文件转化为内存中的session对象即可。

		3. session什么时候被销毁？
			1. 服务器关闭
			2. session对象调用invalidate() 。
			3. session默认失效时间 30分钟
				选择性配置修改
				<session-config>
			        <session-timeout>30</session-timeout>
			    </session-config>

	 5. session的特点
		 1. session用于存储一次会话的多次请求的数据，存在服务器端
		 2. session可以存储任意类型，任意大小的数据

		* session与Cookie的区别：
			1. session存储数据在服务器端，Cookie在客户端
			2. session没有数据大小限制，Cookie有
			3. session数据安全，Cookie相对于不安全
* */
public class sessionChannel extends HttpServlet {
    public void setSession(HttpServletRequest req, HttpServletResponse resp, String key, String value) throws ServletException, IOException {
        System.out.println("---session.setAttribute(key, value);----");

        //1.获取session
        HttpSession session = req.getSession();
        //2.存储数据
        session.setAttribute(key, value);
    }

    public void getSession(HttpServletRequest req, HttpServletResponse resp, String key) throws ServletException, IOException {

        System.out.println("---session.getAttribute(key);----");

        //1.获取session
        HttpSession session = req.getSession();
        //2.获取数据
        Object msg = session.getAttribute(key);
        System.out.println(msg);
    }

    public void setSessionRelyCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("---setSessionRelyCookie----");
        HttpSession session = req.getSession();

//		* 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60);
        resp.addCookie(c);

    }


}
