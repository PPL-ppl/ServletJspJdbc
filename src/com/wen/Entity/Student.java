package com.wen.Entity;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Double score;
    private Date birthday;

    public Student() {
    }

    public Student(Integer id, String name, Double score, Date birthday) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", score = " + score + ", birthday = " + birthday + "}";
    }
}
