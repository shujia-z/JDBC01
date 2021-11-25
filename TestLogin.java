package com.hp.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLogin {
    public static void main(String[] args) {
        List<User> list=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        Scanner scanner=new Scanner(System.in);

        String a=null;
        String b=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool","root","root");
            //3,获取执行发送sql语句的对象statement
            statement = connection.createStatement();
            //4.执行sql语句
            resultSet = statement.executeQuery("select * from Test");
            //5.处理结果集
            while (resultSet.next()){
                String admin = resultSet.getString("admin");
                String pwd = resultSet.getString("pwd");

                //把拿出来的数据封装成对象，并且将对象添加刀list集合中
                User user=new User(admin,pwd);
                list.add(user);

                System.out.println("******************");
                System.out.println("学生信息管理系统");
                System.out.println("******************");
                System.out.println("请输入用户名");
                a =scanner.next();
                System.out.println("请输入密码");
                b =scanner.next();

                for (int i = 0; i < list.size(); i++) {
                    if (a.equals(list.get(i).getAdmin())) {
                        if (b.equals(list.get(i).getPwd())){
                            System.out.println("登陆成功");
                            break;
                        }else {
                            System.out.println("登录失败");
                            continue;
                        }
                    }
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
