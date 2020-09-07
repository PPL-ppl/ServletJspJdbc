package com.wen;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DataSource {
    public static void main(String[] args) {
        //创建c3p0
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/servlettest?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            //初始化连接个数
            dataSource.setInitialPoolSize(20);
            //设置最大连接数
            dataSource.setMaxPoolSize(40);
            //不够继续申请个数
            dataSource.setAcquireIncrement(5);
            //最小连接数
            dataSource.setMinPoolSize(2);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            dataSource.close();//还到缓冲池
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
