package com.lhx.stu_pro.controller;


import com.lhx.stu_pro.bean.User;
import com.lhx.stu_pro.service.StudentService;
import com.lhx.stu_pro.service.StudentServiceIml;
import com.lhx.stu_pro.service.UserService;
import com.lhx.stu_pro.service.UserServiceIml;
import com.lhx.stu_pro.util.FormUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author luomo
 * @create 2022-07-15 19:02
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceIml();
    private StudentService studentService = new StudentServiceIml();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        System.out.println("This is POST,落寞");
        User user = new User();
        FormUtil.formToBean(req.getParameterMap(),user);
        userService.login(user);
        boolean loginOk = userService.login(user);
        if (loginOk){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            req.getRequestDispatcher("/info.jsp").forward(req,resp);
        }
    }
}
