package com.eliza.reqResp.requestL;

import com.eliza.reqResp.ReqMethod.ReqPara;
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

/*
获取请求参数通用方式(get  post 均可用)
    1. string getParameter(string name):根据参数名称获取参数值username=zs&password=123
    2. string[] getParameterValues(String name):根据参数名称获取参数值的数组hobby=xx&hobby=game3. Enumeration<string> getParameterNames():获取所有请求的参数名称
    4. Map<string,string[]>getParameterMap():获取所有参数的map集合2．请求转发∶
    3．共享数据
    4.获取servletcontext

* */
// 获取请求参数
@WebServlet("/getParameter")
public class reqGetParameter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get 获取请求参数
        //根据参数名称获取参数值
/*        String username = req.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
        System.out.println("---/getParameter----");
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("---/getParameter----");
        req.setCharacterEncoding("utf-8");//中文乱码 -》修改编码
        ReqPara reqPara = new ReqPara();
        String keys = "hobby";
        String methodName = null;
        methodName = "getParameter";
//        methodName = "getParameterNames"; //获取所以参数名称
//   methodName =     "getParameterMap";
        reqPara.getPara(req, resp, keys, methodName);

        reqPara.changePageWithoutUrl(req, resp, "/postHeader");

    }


}
