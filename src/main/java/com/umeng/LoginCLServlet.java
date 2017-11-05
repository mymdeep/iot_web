package com.umeng;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VictoricHee on 17/11/4.
 */
public class LoginCLServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//      response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //这里看看接到没有
        System.out.println(username +" "+password);

        //这里我们先简单验证
        if("Gavin".equals(username)&&"123".equals(password)){
            //跳转到下一个页面
            //servlet提供了两种，sendRedirect转向 、forward转发
            //sendRedirect的url应该这样写 ： /web应用名称/servlet的url
            response.sendRedirect("/UsersManager/MainFrame");
        }else{
            //跳回
            response.sendRedirect("/UsersManager/LoginServlet");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);
    }

}