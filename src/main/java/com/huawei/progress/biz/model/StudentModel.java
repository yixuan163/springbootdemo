package com.huawei.progress.biz.model;

import lombok.Data;

/**
 * @Description 学生类
 * @Author
 * @Date 2021/4/5
 * @Version 1.0
 */ 
@Data
public class StudentModel {
    // 主键
    private String id;
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private String sex;
    // 成绩
    private double score;
    public StudentModel(String id, String name, int age, String sex, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }
}
