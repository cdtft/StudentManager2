package com.biz.std.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/14.
 */
public class SubjectFormVo {

    /*
    * 课程ID
    * */
    private Integer id;

    /*
    * 课程名
    * */
    private String name;

    /*
    * 选课的人数
    * */
    private Integer studentNum;

    /*
    * 课程平均成绩
    * */
    private Integer avgScore;

    /*
    * 选课学生名单
    * */
    private List<String> stdNameList = new ArrayList<>();

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

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    public List<String> getStdNameList() {
        return stdNameList;
    }

    public void setStdNameList(List<String> stdNameList) {
        this.stdNameList = stdNameList;
    }
}
