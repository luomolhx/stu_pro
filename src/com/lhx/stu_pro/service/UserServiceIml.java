package com.lhx.stu_pro.service;

import com.lhx.stu_pro.bean.User;
import com.lhx.stu_pro.dao.UserDao;
import com.lhx.stu_pro.dao.UserDaoIml;

/**
 * @author luomo
 * @create 2022-07-16 9:47
 */
public class UserServiceIml implements UserService{

    private UserDao userDao = new UserDaoIml();

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }
}
