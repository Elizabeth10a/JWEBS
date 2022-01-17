package com.eliza.JspSC.CookieSession;
/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/21/21
 * @Software: IntelliJ IDEA
 */

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//响应头
//3. 实现原理  * 基于响应头set-cookie和请求头cookie实现

public class CookieChannel extends HttpServlet {


    public void creatCookie(HttpServletRequest req, HttpServletResponse resp, String msg, int time) {

        //1.创建Cookie对象
        Cookie c = new Cookie(msg, msg);
        /*1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
			2. 持久化存储：
				* setMaxAge(int seconds)
					1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
					2. 负数：默认值
					3. 零：删除cookie信息*/
        c.setMaxAge(time);//秒

        //2.发送Cookie
        resp.addCookie(c);
    }

    /*	1. 创建Cookie对象，绑定数据
                    * new Cookie(String name, String value)
                2. 发送Cookie对象
                    * response.addCookie(Cookie cookie)
                3. 获取Cookie，拿到数据
                    * Cookie[]  request.getCookies()*/
    public void showCookieInfo(HttpServletRequest req, HttpServletResponse resp) {
        //3. 获取Cookie
        Cookie[] cs = req.getCookies();
        //获取数据，遍历Cookies
        if (cs != null) {
            for (Cookie c : cs) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ":" + value);
            }
        }
    }

    /*		4. cookie共享问题？
                1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
                    * 默认情况下cookie不能共享

                    * setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
                        * 如果要共享，则可以将path设置为"/"


                2. 不同的tomcat服务器间cookie共享问题？
                    * setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
                        * setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享
    */
//cookie 作用范围(路径) 默认是当前虚拟路径
    public void setCookieArea(HttpServletRequest req, HttpServletResponse resp, String msg, int time, String path) {

        Cookie c = new Cookie(msg, msg);

        c.setMaxAge(time);//秒
        c.setPath(path);// "/" 同一台服务器下 多个项目路径最大
//        c.setDomain();            //* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享

        resp.addCookie(c);
    }
}
