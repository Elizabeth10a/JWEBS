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
 * @Time    : 10/21/21
 * @Software: IntelliJ IDEA
 */
@WebServlet("/respInfoToClient")
public class respInfoToClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------/respInfoToClient- doGet-");
        RespSome respSome = new RespSome();
//        respSome.sendInfoToCharacter(req, resp, "<h1>你好 as おはよう</1>"); //向客户端 浏览器发送通过字符数据
        //你好 おはよう:   <pre style="word-wrap: break-word; white-space: pre-wrap;">浣犲ソ 銇娿伅銈堛亞</pre>//乱码 ,需要更改编码
//        respSome.sendInfoToBytes(req, resp, "<h1>你好 sendInfoToBytes おはよう</1>");//向客户端 浏览器发送通过字节数据
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------/respInfoToClient- doPost--");

        RespSome respSome = new RespSome();
        respSome.creatCheckImage(req, resp);//生成一张图片(验证码)

    }
}
