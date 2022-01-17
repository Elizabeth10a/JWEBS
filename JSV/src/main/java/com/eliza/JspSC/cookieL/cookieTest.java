package com.eliza.JspSC.cookieL;
/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/27/21
 * @Software: IntelliJ IDEA
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class cookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie为lastTime
        //2.遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是：lastTime
                if ("lastTime".equals(name)) {
                    //有该Cookie，不是第一次访问

                    flag = true;//有lastTime的cookie

                    //设置Cookie的value

                    cookie.setValue(getTime());
                    //设置cookie的存活时间
                    cookie.setMaxAge(30);//一个月
                    response.addCookie(cookie);


                    //响应数据
                    //获取Cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    //URL解码：
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>");


                    break;

                }
            }
        }


        if (cookies == null || cookies.length == 0 || !flag) {
            //没有，第一次访问

            //设置Cookie的value


            Cookie cookie = new Cookie("lastTime", getTime());
            //设置cookie的存活时间
            cookie.setMaxAge(30);//一个月
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    private String getTime() throws UnsupportedEncodingException {
        //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        System.out.println("编码前：" + str_date);
        //URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后：" + str_date);
        return str_date;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
