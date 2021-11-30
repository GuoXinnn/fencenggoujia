package com.hp.demo.service;

import com.hp.demo.pojo.User;

import java.sql.ResultSet;

public interface UserService {
    //用户注册 4.通过admin修改密码   5.通过admin删除用户
    boolean login(User user,String sql,int i);
    //查询
    ResultSet select(User user, String sql);
}
