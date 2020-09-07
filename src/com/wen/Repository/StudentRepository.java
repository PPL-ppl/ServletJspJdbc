package com.wen.Repository;

import com.wen.Entity.Student;
import com.wen.Util.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 19424
 */
public class StudentRepository {
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double score = resultSet.getDouble(3);
                Date birthday = resultSet.getDate(4);
                student = new Student(id, name, score, birthday);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return list;
    }

    public void add(String name, Double score) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "insert into student(name,score,birthday) value(?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, score);
            statement.setDate(3, new java.sql.Date(1));
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    public void deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "delete from student where id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    public Student findById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        connection = JDBCTools.getConnection();
        String sql = "select * from student where id=?";
        Student student = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id2 = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double score = resultSet.getDouble(3);
                Date birthday = resultSet.getDate(4);
                student = new Student(id2, name, score, birthday);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return student;
    }

    public void update(Integer id, String name, Double score) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "update  student set name = ?,score= ? where id= ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, score);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }
}
