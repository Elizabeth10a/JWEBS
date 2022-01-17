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
@WebServlet("/useScope2")
public class useScope2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--useScope!!-  Get---");
        System.out.println(req.getAttribute("大"));//big
        System.out.println(req.getAttribute("name"));//null



    }
}
