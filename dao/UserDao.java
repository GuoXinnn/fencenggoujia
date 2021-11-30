package com.hp.demo.dao;

import com.hp.demo.pojo.User;

import java.sql.ResultSet;

public interface UserDao {
    //用户登录功能(插入) 4.通过admin修改密码   5.通过admin删除用户
    boolean login(User user,String sql,int i);
    //查询
    ResultSet select(User user,String sql);

}
