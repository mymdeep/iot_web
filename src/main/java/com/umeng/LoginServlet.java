package com.umeng;

/**
 * Created by VictoricHee on 17/11/4.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>用户登录</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("<h1>用户登录</h1>");
        //action应该这样写：/web应用名/servlet的url
        out.println("<form action='/UsersManager/LoginCLServlet' method='post'>");
        out.println("用户名：<input type='text' name='username'/><br/>");
        out.println("密    码：<input type='password' name='password'/><br/>");
        out.print("<input type='submit' value='登录'/>");
        out.println("<input type='reset' value='重置'/><br/>");
        out.println("</form>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
