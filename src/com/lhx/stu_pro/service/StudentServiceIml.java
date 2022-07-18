package com.lhx.stu_pro.service;

import com.lhx.stu_pro.bean.Student;
import com.lhx.stu_pro.dao.StudentDao;
import com.lhx.stu_pro.dao.StudentDaoIml;

import java.util.List;
import java.util.Map;

/**
 * @author luomo
 * @create 2022-07-16 10:07
 */
public class StudentServiceIml implements StudentService{

    private StudentDao studentDao = new StudentDaoIml();

    @Override
    public List<Student> queryAll() {
        return null;
    }

    @Override
    public boolean deleteStu(String sid) {
        return false;
    }

    @Override
    public Student queryById(String sid) {
        return null;
    }

    @Override
    public boolean updateStu(Student student) {
        return false;
    }

    @Override
    public boolean deleteBath(String sids) {
        return false;
    }

    @Override
    public int count(Map<String, String> map) {
        return 0;
    }

    @Override
    public List<Student> queryPagination(int page, int pageSize, Map<String, String> map) {
        return null;
    }
}
