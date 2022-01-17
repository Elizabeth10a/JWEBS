package com.eliza.reqResp.requestL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/20/21
 * @Software: IntelliJ IDEA
 */
@WebServlet("/useScope1")
public class useScope1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("--useScope!!----");
        req.setAttribute("大", "big");
//客户端外部访问需要加虚拟路径  resp.sendRedirect();-->
//服务器内部访问不需要加虚拟路径 forward -->
        req.getRequestDispatcher("/useScope2").forward(req, resp);
        //当页面跳转，其之后代码不会执行
        System.out.println("req.setAttribute()");
        req.setAttribute("name", "法外狂徒");

    }
}
