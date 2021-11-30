package com.hp.demo.service;

import com.hp.demo.dao.UserDao;
import com.hp.demo.dao.impl.UserDaoImpl;
import com.hp.demo.pojo.User;

import java.sql.ResultSet;

public class UserServiceImpl implements UserService{

    @Override
    //1.注册 4.通过admin修改密码   5.通过admin删除用户
    public boolean login(User user,String sql,int i) {
        UserDao userDao=new UserDaoImpl();
        boolean login = userDao.login(user,sql,i);
        return login;
    }

    @Override
    public ResultSet select(User user, String sql) {
        UserDao userDao=new UserDaoImpl();
        ResultSet select = userDao.select(user, sql);
        return select;
    }
}
