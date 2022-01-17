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
    1，概念∶服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession
    *2.快速入门:
        Httpsession对象︰
        object. getAttribute( string name)
        void

* */
@WebServlet("/sessionBase1")

public class sessionBase1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sessionChannel sc = new sessionChannel();
        sc.getSession(req, resp, "msg");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
