package com.lhx.stu_pro.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luomo
 * @create 2022-07-16 9:37
 */
public class BaseServlet extends HttpServlet {

    private String methodName;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取方法参数值
        methodName = req.getParameter("method");
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("对不起，您调用"+methodName+"方法不存在");
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
