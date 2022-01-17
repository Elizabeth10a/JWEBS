package com.eliza.reqResp.ReqMethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/20/21
 * @Software: IntelliJ IDEA
 */
public class ReqBody extends HttpServlet {
    //获取 请求头 体 数据

/* Post请求默认的请求体  ：
application/x- www-form-urlencoded是内容类型，也是form表单默认的类型 request.getParameter()方法来获取请求参数值
    request.getInputStream()  或request.getReader()也可行

multipart/form-data或application/json时。
    只能通过request.getInputStream()和request.getReader()方法获取请求内容

对该类型的请求，三个方法互斥，只能调其中一个

* */
    /*
     获取请求体数据:
        *请求体∶只有PoST请求方式，才有请求体，在请求体中封装了POST请求的请求参数*步骤︰
        1．获取流对象
            *BufferedReader getReader():获取字符输入流，只能操作字符数据
            *ServletInputstream getInputstream():获取字节输入流，可以操作所有类型数据
*/

    /**
     * @param req
     * @param resp 获取请求体
     * @throws ServletException
     * @throws IOException
     */
    public void postReaderRequestBody(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("-------- req.getReader();--------");
        System.out.println("表单：enctype=\"multipart/form-data\">");//InputStreamReader 同此
        BufferedReader reader = req.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }

    public void postInputStreamRequestBody(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----postInputStreamRequestBody------");
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }

    }

}
