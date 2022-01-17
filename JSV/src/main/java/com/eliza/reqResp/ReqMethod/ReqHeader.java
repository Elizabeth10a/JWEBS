package com.eliza.reqResp.ReqMethod;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/20/21
 * @Software: IntelliJ IDEA
 */
public class ReqHeader extends HttpServlet {
//获取 请求头 行 数据

    /**
     * @param req
     * @param resp
     * @throws IOException 获取request 信息
     */
    public void getRequestInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
             /*
            1. 获取请求方式 :GET
                * String getMethod()
            2. (*)获取虚拟目录:/day14
                * String getContextPath()
            3. 获取Servlet路径: /requestDemo1
                * String getServletPath()
            4. 获取get方式请求参数:name=zhangsan
                * String getQueryString()
            5. (*)获取请求URI:/day14/demo1
                * String getRequestURI():		/day14/requestDemo1
                * StringBuffer getRequestURL()  :http://localhost/day14/requestDemo1
            6. 获取协议及版本:HTTP/1.1
                * String getProtocol()

            7. 获取客户机的IP地址:
                * String getRemoteAddr()

         */
        System.out.println("--------request请求信息------------");
        System.out.println("获取请求方式:req.getMethod:\t\t" + req.getMethod());
        //2.(*)获取虚拟目录:
        System.out.println("获取虚拟目录Servlet请求路径:req.getContextPath:\t\t" + req.getContextPath());
        /*
         * 获取请求相对URL: req.getRequestURI      :/JHtml/getHeaderInfo
         * 请求全路径URL:http://192.168.59.129:8080/JHtml/getHeaderInfo
         * */
        //3. 获取Servlet路径:
        System.out.println("获取Servlet路径:req.getServletPath:\t\t" + req.getServletPath());
        //4. 获取get方式请求参数:name=zhangsan
        System.out.println("获取get方式请求参数:req.getQueryString:\t" + req.getQueryString());


        //5.(*)获取请求URI:/day14/demo1
        System.out.println("获取请求相对URI:req.getRequestURI:\t\t" + req.getRequestURI());//范围更广
        System.out.println("请求全路径URL:\t" + req.getRequestURL());
        //6. 获取协议及版本:HTTP/1.1
        System.out.println("获取协议及版本:req.getProtocol:\t\t" + req.getProtocol());
        //7. 获取客户机的IP地址:
        System.out.println("获取客户机的IP地址:req.getRemoteAddr:\t" + req.getRemoteAddr());

    }

    /**
     * @param req
     * @param resp
     * @throws IOException 获取request 请求头信息
     */
    public void getRequestHeaderInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("--------获取所有请求头名称-----");

        //1.获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        System.out.println(headerNames);
        System.out.println("---请求头内容-----");
        //2.遍历
        while (headerNames.hasMoreElements()) {//测试此枚举是否包含更多元素
            String name = headerNames.nextElement();//
            //根据名称获取请求头的值
            String value = req.getHeader(name);//通过请求头的名称获取请求头的值
            System.out.println(name + ":" + value);
        }

        System.out.println("----获取特定的请求头数据----");

        String referer = req.getHeader("Accept-Encoding");
        System.out.println(referer);//http://localhost/day14/login.html

        //防盗链
        if (referer != null) {
            if (referer.contains("/day14")) {
                //正常访问
                // System.out.println("播放电影....");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放电影....");
            } else {
                //盗链
                //System.out.println("想看电影吗？来优酷吧...");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("想看电影吗？来优酷吧...");
            }
        }

    }

    /**
     * @param req
     * @param resp
     * @throws IOException 获取request 请求头信息 UserAgent
     */
    public void getRequestHeaderUserAgentInfo(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("---获取请求头数据:user-agent----");
        String agent = req.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            //谷歌
            System.out.println("谷歌来了...");
        } else if (agent.contains("Firefox")) {
            //火狐
            System.out.println("火狐来了...");
        }
    }


}
