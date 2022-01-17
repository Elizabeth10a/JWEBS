package com.eliza.JspSC.sessionL;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/27/21
 * @Software: IntelliJ IDEA
 */

import com.eliza.JspSC.CookieSession.sessionChannel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* session :
	1. 概念：服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession
	2. 快速入门：
		1. 获取HttpSession对象：
			HttpSession session = request.getSession();
		2. 使用HttpSession对象：
			Object getAttribute(String name)
			void setAttribute(String name, Object value)
			void removeAttribute(String name)

	3. 原理
		* Session的实现是依赖于Cookie的。
        请求头 cookie :JSESSION=
* */
@WebServlet("/sessionBase")
public class sessionBase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sessionChannel sc = new sessionChannel();
        sc.setSession(req, resp, "msg", "hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}