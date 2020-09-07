package com.wen;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wen.Entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class DbutilsDemo {
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource("testc3p0");
    }

    public static void main(String[] args) {
        Student byId = findById();
        System.out.println(byId);
        Student student = FindByIdByDbUtil(1, 22.0);
        System.out.println(student);
        findAll().forEach(System.out::println);
    }

    public static Student FindByIdByDbUtil(Integer id, Double score) {
        Student query = null;
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from student where id=? and score=?";
            QueryRunner queryRunner = new QueryRunner();
            query = queryRunner.query(connection, sql, new BeanHandler<>(Student.class), id, score);
            //MapHandler将BeanHandler的对象以键值对的方式存储 id:1,name:涨三倍
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    public static List<Student> findAll() {
        List<Student> query = null;
        Connection connection;
        try {
            connection = dataSource.getConnection();
            String sql1 = "select * from student";
            QueryRunner queryRunner = new QueryRunner();
            query = queryRunner.query(connection, sql1, new BeanListHandler<>(Student.class));
            //BeanListHandler是List<Student>
            // MapListHandler将BeanListHandler变成List<Map<String,Object>>
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    public static Student findById() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student query = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from student where id=1";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double score = resultSet.getDouble(3);
                Date date = resultSet.getDate(4);
                query = new Student(id, name, score, date);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }
}
