package com.biz.std.vo;

import com.biz.std.model.Grade;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by king on 2017/5/11.
 */
public class StudentFormVo {
    /*
    * 姓名
    * */
    private String name;

    /*
    * 性别
    * */
    private String gender;

    /*
    * 出生日期
    * */
    private Date birthday;

    /*
    * 学号
    * */
    private Integer id;

    /*
    * 住址
    * */
    private String addr;

    /*
    * 年龄
    * */
    private int age;

    /*
    * 所在年级
    * */
    private String gradeName;

    /*
    * 总分数
    * */
    private Integer totalScore;

    /*
    * 所学课程
    * */
    private List<String> subjectList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("gender", gender)
                .append("birthday", birthday)
                .append("id", id)
                .append("addr", addr)
                .append("age", age)
                .append("gradeName", gradeName)
                .append("totalScore", totalScore)
                .append("subjectList", subjectList)
                .toString();
    }
}
