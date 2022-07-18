package com.lhx.stu_pro.dao;

import com.lhx.stu_pro.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @author luomo
 * @create 2022-07-16 10:10
 */
public interface StudentDao {
    List<Student> queryAll();

    boolean deleteStu(String sid);

    Student queryById(String sid);

    boolean updateStu(Student student);

    boolean deleteBath(String sids);

    int count(Map<String, String> map);

    List<Student> queryPagination(int page, int pageSize, Map<String, String> map);
}
