package com.hp.demo.dao.impl;

import com.hp.demo.dao.UserDao;
import com.hp.demo.pojo.User;
import com.hp.demo.utils.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    //用户注册(插入数据)4.通过admin修改密码   5.通过admin删除用户
    public boolean login(User user,String sql,int i) {
        if (i==1) {
            int update = BaseDao.update(sql, new Object[]{user.getName(), user.getPassword()});
            if (update>0) {
                return true;
            }
        }else if (i==4){
            int update = BaseDao.update(sql, new Object[]{user.getPassword(), user.getName()});
            if (update>0) {
                return true;
            }
        }else {
            int update = BaseDao.update(sql, new Object[]{user.getName()});
            if (update>0) {
                return true;
            }
        }

        return false;
    }

    @Override
    //2.查看所有用户  3.通过admin查询用户
    public ResultSet select(User user, String sql) {
        ResultSet query =null;
        try {
            if (user == null) {
                 query = BaseDao.query(sql, null);
            }else {
                query = BaseDao.query(sql, new Object[]{user.getName()});
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }
}
