package com.eliza.JspSC.cookieL;
/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/21/21
 * @Software: IntelliJ IDEA
 */

import com.eliza.JspSC.CookieSession.CookieChannel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/useCookie")
public class useCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----getCookie-doPost----");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//  //  //  //
        System.out.println("-----getCookie-doGet----");
        CookieChannel cookieChannel = new CookieChannel();
        //使用response调用多次addCookie方法发送cookie即可
        cookieChannel.creatCookie(req, resp, "oool", 10);
        cookieChannel.creatCookie(req, resp, "ok", -1);
//        cookieChannel.creatCookie(req, resp, "在", -1);//Tomcat 10.1.0-M4 报错
//        cookieChannel.creatCookie(req, resp, "sp", 0);

        this.doPost(req, resp);
    }

    private void sendChinese() {

    }

}
