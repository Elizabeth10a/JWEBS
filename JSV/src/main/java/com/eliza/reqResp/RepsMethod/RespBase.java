package com.eliza.reqResp.RepsMethod;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 10/20/21
 * @Software: IntelliJ IDEA
 */

/*
* HTTP协议︰
    1．请求消息:客户端发送给服务器端的数据
*数据格式:
1．请求行2．请求头3．请求空行4．请求体
    2．响应消息:服务器端发送给客户端的数据
*数据格式:
    1．响应行
        组成︰协议/版本 响应状态码 状态码描述
       分类∶
        1. 1xx∶服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
        2. 2xx∶成功。代表:200
        3. 3xx:重定向。代表:302(重定向) 304（访问缓存，存在相同资源）
        4. 4xx:客户端错误 405(请求方式没有对应的方法)
        5. 5xx:服务端错误 500 内部异常

    2．响应头
        1.格式∶ K ： V
        2.常见的响应头:
            content-Type:服务器告诉客户端本次响应体数据格式以及编码格式
            Content-disposition：服务器告诉客户端以什么格式打开响应体数据
                * 值：
                    * in-line:默认值,在当前页面内打开
                    * attachment;filename=xxx：以附件形式打开响应体。文件下载
    3. 响应空行
	4. 响应体:传输的数据

*------------
* * 响应字符串格式
			HTTP/1.1 200 OK
			Content-Type: text/html;charset=UTF-8
			Content-Length: 101
			Date: Wed, 06 Jun 2018 07:08:42 GMT
			<html>
			  <head>
			    <title>$Title$</title>
			  </head>
			  <body>
			  hello , response
			  </body>
			</html>
* */
/*
*## Response对象
	* 功能：设置响应消息
		1. 设置响应行
			1. 格式：HTTP/1.1 200 ok
			2. 设置状态码：setStatus(int sc)
		2. 设置响应头：setHeader(String name, String value)

		3. 设置响应体：
			* 使用步骤：
				1. 获取输出流
					* 字符输出流：PrintWriter getWriter()
					* 字节输出流：ServletOutputStream getOutputStream()
				2. 使用输出流，将数据输出到客户端浏览器*/
public class RespBase {
}
