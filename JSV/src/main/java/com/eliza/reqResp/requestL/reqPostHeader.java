package com.eliza.reqResp.requestL;
/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/20/21
 * @Software: IntelliJ IDEA
 */

import com.eliza.reqResp.ReqMethod.ReqBody;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//获取请求体信息
@WebServlet(name = "reqPostHeader", value = "/postHeader")
public class reqPostHeader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-doPost--");
        ReqBody reqBody = new ReqBody();
        //只能用一个
        reqBody.postReaderRequestBody(req, resp);
//        reqBody.postInputStreamRequestBody(req, resp);


    }


}
