package com.lhx.stu_pro.controller;

import com.lhx.stu_pro.bean.Student;
import com.lhx.stu_pro.service.StudentService;
import com.lhx.stu_pro.service.StudentServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author luomo
 * @create 2022-07-16 10:58
 */
@WebServlet("/studentServlet")
public class StudentServlet extends BaseServlet{
    private StudentService studentService = new StudentServiceIml();

    //删除
    public void deleteStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        boolean deleteOK = studentService.deleteStu(sid);
        if (deleteOK){
            //在此查询数据
            List<Student> students = studentService.queryAll();
            req.setAttribute("students",students);
            //转发到指定页面
            req.getRequestDispatcher("/").forward(req,resp);
        }
    }

}
