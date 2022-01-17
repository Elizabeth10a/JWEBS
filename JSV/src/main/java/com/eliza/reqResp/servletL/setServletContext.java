package com.eliza.reqResp.servletL;

import com.eliza.reqResp.ReqMethod.ReqServletContext;
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
@WebServlet("/setServletContext")
public class setServletContext extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----setServletContext doPost--------");

        ReqServletContext reqSc = new ReqServletContext();
//        String webFilePath = "RespResource/CheckImage.html";
// xx +out/artifacts/JSV_war_exploded/RespResource/CheckImage.html
        String webFilePath = "classes/com/jsv/jhtml/servletL/valueServletContext.java";
//        String webFilePath = "/WEB-INF/web.xml";
//xx+ out/artifacts/JSV_war_exploded/classes/com/jsv/jhtml/servletL/valueServletContext.java
        reqSc.getRealPath(req, resp, webFilePath);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----setServletContext doGet--------");
        ReqServletContext reqSC = new ReqServletContext();
        reqSC.getServletContext(req, resp);


        System.out.println(req.getServletContext() == this.getServletContext());
        reqSC.getDataType(req, resp);//image/sun.awt.www.content.image.png

//        获取数据 ServletContext() .getAttribute("scMsg")
        System.out.println("valueServletContext: " + this.getServletContext().getAttribute("scMsg"));
        this.doPost(req, resp);

    }
}
