package com.lhx.stu_pro.dao;

import cn.hutool.core.util.StrUtil;
import com.lhx.stu_pro.bean.Student;
import com.lhx.stu_pro.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author luomo
 * @create 2022-07-16 10:15
 */
public class StudentDaoIml implements StudentDao {
    private QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public List<Student> queryAll() {
        String sql = "select * from t_student";
        List<Student> students = null;
        try {
            students = qr.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteStu(String sid) {
        String sql = "delete from t_student where sid = ?";
        try {
            int update = qr.update(sql, sid);
            return update > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student queryById(String sid) {
        String sql = "select * from t_student where sid = ?";
        Student student = null;
        try {
            student = qr.query(sql, new BeanHandler<>(Student.class), sid);
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateStu(Student student) {
        String sql = "update t_student set sname = ?,age = ?" +
                ",gender = ? where sid = ?";
        try {
            int update = qr.update(sql, student.getSname(), student.getAge(), student.getGender(), student.getSid());
            return update > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBath(String sids) {
        String[] split = sids.split(",");
        int update = 0;
        for (String sid : split) {
            String sql = "delete from t_student where sid = ?";
            try {
                update = qr.update(sql, sid);
                if (update < 0) {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public int count(Map<String, String> map) {
        //查询的数量
        Long count = null;
        StringBuffer sb = new StringBuffer("select count(*) from t_student where");
        if (StrUtil.isNotEmpty(map.get("sname"))) {
            sb.append(" sname like ? and");
        }
        sb.append(" 1 = 1");
        if (StrUtil.isNotEmpty(map.get("age"))) {
            sb.append(" and age > ?");
        }

        try {
            if (map.size() == 0) {
                count = qr.query(sb.toString(), new ScalarHandler<>());
            } else {
                if (map.size() == 1) {
                    if (StrUtil.isNotEmpty(map.get("sname"))) {
                        count = qr.query(sb.toString(), new ScalarHandler<>(), "%" + map.get("sanme") + "%");
                    } else if (StrUtil.isNotEmpty(map.get("age"))) {
                        count = qr.query(sb.toString(), new ScalarHandler<>(), map.get("age"));
                    }
                } else {
                    count = qr.query(sb.toString(), new ScalarHandler<>(), "%" + map.get("sanme") + "%", map.get("age"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("conut:" + sb);
        return count.intValue();
    }

    @Override
    public List<Student> queryPagination(int page, int pageSize, Map<String, String> map) {
        List<Student> students = null;
        StringBuffer sb = new StringBuffer("select * from t_student where");
        if (StrUtil.isNotEmpty(map.get("sanme"))) {
            sb.append(" sname like ? and");
        }
        sb.append(" 1 = 1");
        if (StrUtil.isNotEmpty(map.get("age"))) {
            sb.append(" and age > ?");
        }
        sb.append(" limit ?,?");
        System.out.println("query:" + sb);
        int a = (page - 1) * pageSize;

        try {
            if (map.size() == 0) {
                students = qr.query(sb.toString(), new BeanListHandler<>(Student.class), a, pageSize);
            } else {
                if (map.size() == 1) {
                    if (StrUtil.isNotEmpty(map.get("sanme"))) {
                        students = qr.query(sb.toString(), new BeanListHandler<>(Student.class),
                                "%" + map.get("sanme") + "%", a, pageSize);
                    } else if (StrUtil.isNotEmpty(map.get("age"))) {
                        students = qr.query(sb.toString(),new BeanListHandler<>(Student.class),
                                map.get("age"),a,pageSize);
                    }
                }else {
                    students = qr.query(sb.toString(),new BeanListHandler<>(Student.class),
                            "%" + map.get("sname") + "%",map.get("age"),
                            a,pageSize);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
