package com.eliza.reqResp.ReqMethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/20/21
 * @Software: IntelliJ IDEA
 */
public class ReqPara extends HttpServlet {
    //获取请求参数 通用方式
    public void getPara(HttpServletRequest req, HttpServletResponse resp, String keys, String method) {
        //根据参数名称获取参数值
        switch (method) {
            case "getParameter":
                System.out.println("----getParameter[Values] 获取指定参数 ------");
                System.out.println(req.getParameter(keys));
                System.out.println(Arrays.toString(req.getParameterValues(keys)));//NULL
                System.out.println(Arrays.toString(req.getParameterValues("password")));//NULL
                break;
            case "getParameterNames":
                System.out.println("-----req.getParameterNames();获取所以参数名称----");
                Enumeration<String> parameterNames = req.getParameterNames();
                while (parameterNames.hasMoreElements()) {
                    String name = parameterNames.nextElement();
                    System.out.println(name);
                    String value = req.getParameter(name);
                    System.out.println(value);
                }
                break;

            case "getParameterMap":
                System.out.println("----- req.getParameterMap() 获取所有参数集合----");
                Map<String, String[]> parameterMap = req.getParameterMap();
                //遍历
                for (String name : parameterMap.keySet()) {
                    //获取键获取值
                    for (String value : parameterMap.get(name)) {
                        System.out.println(name + ":" + value);
                    }
                }
                break;

        }


//        String[] hobbies = req.getParameterValues(keys);
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }
    }

    //请求转发 -》服务器内部的资源跳转方式
/*
* 请求转发:—种在服务器内部的资源跳转方式
    1，通过request对象获取请求转发器对象∶
        * RequestDispatcher getRequestDispatcher(String path)
    2．使用RequestDispatcher对象来进行转发∶
        * forward(ServletRequest request，ServletResponse response)
   特点∶
    1.浏览器地址栏路径不发生变化
    2.只能访问当前服务器内部
    3.使用同一次请求
* */
    public void changePageWithoutUrl(HttpServletRequest req, HttpServletResponse resp, String target)  {
        try {
            req.getRequestDispatcher(target).forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    /*
    共享数据︰
    域对象:一个有作用范围的对象，可以在范围内共享数据
        *request域:代表一次请求的范围，一般用于请求转发的多个资源中共享数据
        1. setAttribute(string name,object obj):存储数据
        2.Object getAttitude( string name):通过键获取值
        3.void removeAttribute(string name):通过键移除键值对


    */
    public void setScope(HttpServletRequest req, HttpServletResponse resp, String k, String v) {
        req.setAttribute(k, v);
    }

    public void rmScope(HttpServletRequest req, HttpServletResponse resp, String k) {
        req.removeAttribute(k);
    }


}
