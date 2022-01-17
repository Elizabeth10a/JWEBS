package com.eliza.reqResp.RepsMethod;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RespSome extends HttpServlet {

    /*
    *
    * 重定向的特点
        1．地址栏发生变化
        2．重定向可以访问其他站点(服务器)的资源
        3．重定向是两次请求l
    转发的特点︰
        1．转发地址栏路径不变
        2．转发只能访问当前服务器下的资源
        3．转发是一次请求

    * */
    public void RedirectTo(HttpServletRequest req, HttpServletResponse resp, String target) {
        resp.setStatus(302);//状态码表示重定向
        resp.setHeader("location", target);// 响应头
    }
    /* 设置响应体：
			* 使用步骤：
				1. 获取输出流
					* 字符输出流：PrintWriter getWriter()
					* 字节输出流：ServletOutputStream getOutputStream()
				2. 使用输出流，将数据输出到客户端浏览器*/

    //不能同时存在
    public void sendInfoToCharacter(HttpServletRequest req, HttpServletResponse resp, String target) throws IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
        // resp.setCharacterEncoding("utf-8");

        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
//        resp.setHeader("content-type", "text/html;charset=utf-8");

        //简单的形式，设置编码
        resp.setContentType("text/html;charset=utf-8");//写在最前面

        PrintWriter pw = resp.getWriter();//获取字符输出流
        pw.write(target);

    }

    public void sendInfoToBytes(HttpServletRequest req, HttpServletResponse resp, String target) throws IOException {

        //简单的形式，设置编码
        resp.setContentType("text/html;charset=utf-8");//写在最前面
        ServletOutputStream sos = resp.getOutputStream();
        //2.输出数据
        sos.write(target.getBytes(StandardCharsets.UTF_8));
        sos.flush();
    }

    //    验证码生成: 一方法在内存中生产图片
    public void creatCheckImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//图片类型


        //2.美化图片
//        2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0, 0, width, height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);//-1 边框是有宽度的
//     写验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3写验证码
            g.drawString(ch + "", width / 5 * i, height / 2);
        }

        //2.4画干扰线
        g.setColor(Color.GREEN);

        //随机生成坐标点

        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);//x1,y1;x2,y2
        }


        ImageIO.write(image, "jpg", resp.getOutputStream());//将图片数据写入
    }
}