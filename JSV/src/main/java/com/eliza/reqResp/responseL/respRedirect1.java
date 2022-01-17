package com.eliza.reqResp.responseL;

import com.eliza.reqResp.RepsMethod.RespSome;
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
@WebServlet("/respRedirect1")
public class respRedirect1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("-----respRedirect1-doPost---");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----respRedirect1--doGet--");
        //页面跳转
        RespSome respSome = new RespSome();
        //respSome.RedirectTo(req, resp, "/JSV/respRedirect2");
        //动态获取虚拟目录
        req.setAttribute("msg", "resp");//设置req阈值

//        respSome.RedirectTo(req, resp, req.getContextPath() + "/respRedirect2");//状态码 跳转
        resp.sendRedirect(req.getContextPath() + "/respRedirect2");


//        resp.sendRedirect("http://www.itcast.cn");//可以直接外部链接
        this.doPost(req, resp);//跳转
    }
}
