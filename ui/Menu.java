package com.hp.demo.ui;

import com.hp.demo.pojo.User;
import com.hp.demo.service.UserService;
import com.hp.demo.service.UserServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    //用户登录界面
    Scanner scanner=new Scanner(System.in);
    UserService userService=new UserServiceImpl();
    public void mainMenu() throws SQLException {
        System.out.println("*******************用户管理******************");
        System.out.println("请选择以下功能:");
        System.out.println("1、注册");
        System.out.println("2、查看所用用户");
        System.out.println("3、通过admin查询用户");
        System.out.println("4、通过admin修改密码");
        System.out.println("5、通过admin删除用户");
        System.out.println("请输入你选择的功能:");
        String s = scanner.nextLine();
        switch (s){
            case "1":
                System.out.println("请输入你的用户名:");
                String name = scanner.nextLine();
                System.out.println("请输入你的密码:");
                String  pwd= scanner.nextLine();
                User user=new User(name,pwd);
                String sql="insert into users value(?,?)";
                boolean login = userService.login(user,sql,1);
                if (login) {
                    System.out.println("注册成功");
                }else {
                    System.out.println("注册失败");
                }
                break;
            case "2":
                ResultSet select = userService.select(null, "select name,password from users");
                System.out.println("用户名          密码");
                while (select.next()){
                    System.out.println(select.getString(1)+"          "+select.getString(2));
                }
                break;
            case "3":
                System.out.println("请输入你要查询的用户：");
                String name1 = scanner.nextLine();
                User user1=new User(name1,null);
                ResultSet select1 = userService.select(user1, "select name,password from users where name=?");
                System.out.println("用户名          密码");
                while (select1.next()){
                    System.out.println(select1.getString(1)+"          "+select1.getString(2));
                }
                break;
            case "4":
                System.out.println("请输入你要修改的用户：");
                String name2 = scanner.nextLine();
                System.out.println("请输入你的新密码:");
                String pwd1 = scanner.nextLine();
                User user2=new User(name2,pwd1);
                boolean login1 = userService.login(user2, "update users set password=? where name=?", 4);
                if (login1) {
                    System.out.println("修改成功");
                }else {
                    System.out.println("修改失败");
                }
                break;
            case "5":
                System.out.println("请输入你要删除的用户：");
                String name3 = scanner.nextLine();
                User user3=new User(name3,null);
                boolean login2 = userService.login(user3, "delete from users where name=?", 5);
                if (login2) {
                    System.out.println("修改成功");
                }else {
                    System.out.println("修改失败");
                }
                break;
            default:
                System.out.println("抱歉，我们现在还没有该功能!!!!");
        }
    }
}
