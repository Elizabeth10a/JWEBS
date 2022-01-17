package com.eliza.reqResp.requestL;

import com.eliza.reqResp.ReqMethod.ReqHeader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
request对象继承体系结构:
ServletRequest		--	接口
	|	继承
HttpServletRequest	-- 接口
	|	实现
org.apache.catalina.connector.RequestFacade 类(tomcat)
 */
/*

执行原理:
	1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
	2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
	3. 如果有，则在找到对应的<servlet-class>全类名
	4. tomcat会将字节码文件加载进内存，并且创建其对象
	5. 调用其方法
* Servlet中的生命周期方法:
	1. 被创建:执行init方法，只执行一次
		* Servlet什么时候被创建？
			* 默认情况下，第一次被访问时，Servlet被创建
			* 可以配置执行Servlet的创建时机。
				* 在<servlet>标签下配置
					1. 第一次被访问时，创建
                		* <load-on-startup>的值为负数
		            2. 在服务器启动时，创建
		                * <load-on-startup>的值为0或正整数
* */

//get 获取请求头 信息
@WebServlet("/getHeader")//一文件多名称，不可 一名称多文件
public class reqGetHeader extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req != null && resp != null) {
            ReqHeader getHead = new ReqHeader();
            getHead.getRequestInfo(req, resp);
            getHead.getRequestHeaderInfo(req, resp);
            getHead.getRequestHeaderUserAgentInfo(req, resp);

        }
    }


}