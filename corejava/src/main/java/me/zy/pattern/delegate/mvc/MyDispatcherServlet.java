package me.zy.pattern.delegate.mvc;

import me.zy.pattern.delegate.mvc.controllers.MemberController;
import me.zy.pattern.delegate.mvc.controllers.OrderController;
import me.zy.pattern.delegate.mvc.controllers.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyDispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //简单演示委派模式在源码中的使用方式
    public void doDispatch(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String uri = request.getRequestURI();
        String mid = request.getParameter("mid");

        if("getMemberById".equals(uri)){
            new MemberController().getMemberById();
        }else if("getOrderById".equals(uri)){
            new OrderController().getOrderById();
        }else if("logout".equals(uri)){
            new SystemController().logout();
        }else {
            response.getWriter().write("404 NOT FOUND!");
        }
    }
}
