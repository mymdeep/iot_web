package com.umeng.db;

import java.sql.*;
/**
 * Created by VictoricHee on 17/11/5.
 */
public class DBUtil {
    private static String Drivde="org.sqlite.JDBC";
    private static  Connection connection;
    private static  Statement statement;
    public static void init () {
        try {
            Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
             connection = DriverManager.getConnection("jdbc:sqlite:db/zhou.db");//连接数据库zhou.db,不存在则创建
             statement = connection.createStatement();   //创建连接对象，是Java的一个操作数据库的重要接口
            String sql="create table tables(name varchar(20),pwd varchar(20))";
            statement.executeUpdate("drop table if exists tables");//判断是否有表tables的存在。有则删除
            statement.executeUpdate(sql);            //创建数据库
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insert(String name,String password){
        try {
            statement.executeUpdate("insert into tables values('zhou','156546')");//向数据库中插入数据
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getvalue(String name){
        ResultSet rSet= null;//搜索数据库，将搜索的放入数据集ResultSet中
        String aaa ="" ;
        try {
            rSet = statement.executeQuery("select*from tables");
            while (rSet.next()) {            //遍历这个数据集
                System.out.println("姓名："+rSet.getString(1));//依次输出 也可以这样写 rSet.getString(“name”)
                System.out.println("密码："+rSet.getString("pwd"));
                aaa =rSet.getString("pwd");
            }
            rSet.close();//关闭数据集

            return aaa;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
