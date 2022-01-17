package com.eliza.reqResp.servletL;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/21/21
 * @Software: IntelliJ IDEA
 */
@WebServlet("/valueServletContext")
public class valueServletContext extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--valueServletContext--doPost-----");

        ServletContext sc = this.getServletContext();
        sc.setAttribute("scMsg", "haha");//生命周期贼长,服务器关闭才结束
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
