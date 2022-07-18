package com.lhx.stu_pro.dao;

import com.lhx.stu_pro.bean.User;

/**
 * @author luomo
 * @create 2022-07-16 9:48
 */
public interface UserDao {
    boolean login(User user);
}
