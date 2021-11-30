package com.hp.demo.test;

import com.hp.demo.ui.Menu;
import com.hp.demo.utils.BaseDao;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Menu menu=new Menu();
        menu.mainMenu();
        BaseDao.close();
    }
}
