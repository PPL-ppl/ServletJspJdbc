package com.wen.Util;

import java.sql.*;

public class JDBCTools {
    private static Connection connection;
    private static String url = "jdbc:mysql://127.0.0.1:3306/servlettest?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static String username = "root";
    private static String password = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
