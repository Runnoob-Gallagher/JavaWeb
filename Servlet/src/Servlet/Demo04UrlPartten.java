package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/one","/two","/three"})
//@WebServlet("/one/two")  表示层级目录
//@WebServlet("/one/*")   表示one后面可以任意          就相当于通配符
//@WebServlet("*/two")    表示two前面可以任意
public class Demo04UrlPartten extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UrlPartten可以存放几个地址");
    }
}
