package com.biz.std.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by king on 2017/5/10.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{

    private static final long serialVersionUID = 5610256021336051603L;

    /*
     * 学号
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /*
    * 姓名
    * */
    @Column(name = "name", length = 40)
    private String name;

    /*
    * 性别
    * */
    @Column(name = "gender", length = 11)
    private String gender;

    /*
    * 出生日期
    * */
    @Column(name = "birthday")
    private Date birthday;

    /*
    * 家庭住址
    * */
    @Column(name = "addr", length = 40)
    private String addr;

    /*
    * 和班级的关系
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    /*
    * 和分数的关系
    * */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Score> scores = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}
