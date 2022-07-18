package com.lhx.stu_pro.dao;

import com.lhx.stu_pro.bean.User;
import com.lhx.stu_pro.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @author luomo
 * @create 2022-07-16 9:49
 */
public class UserDaoIml implements UserDao{

    private QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public boolean login(User user) {
        String sql = "select count(*) from t_user where " +
                "username = ? and password = ?";
        try {
            Number number = qr.query(sql,new ScalarHandler<>(),user.getUsername(),user.getPassword());
            return number.intValue() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
