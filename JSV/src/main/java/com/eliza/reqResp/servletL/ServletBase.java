package com.eliza.reqResp.servletL;
/*-*- coding:utf-8 -*-
 * @Author  : mint
 * @Time    : 10/18/21
 * @Software: IntelliJ IDEA
 */


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "ServletBase", value = "/ServletBase")
public class ServletBase implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * @param servletRequest  获取请求
     * @param servletResponse 获取相应
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo1....");//浏览器访问该url，本地（服务器输出信息）
        System.out.println(servletRequest );
    }

    /*
        1. request和response对象是由服务器创建的。我们来使用它们
        2. request对象是来获取请求消息，response对象是来设置响应消息
        请求消息：
            1.请求行
                请求方式 请求url 请求协议/版本
                GET /login.html	HTTP/1.1（keep-alive）
            2.请求头：客户端浏览器告诉服务器一些信息
            3.请求空行： 空行，就是用于分割POST请求的请求头，和请求体的。
            4.请求体(正文)：（get  没有）封装POST请求消息的请求参数的
    */
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
