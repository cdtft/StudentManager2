package com.biz.std.vo;

import com.biz.std.model.Score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/15.
 */
public class ScoreFormVO {

    private Integer stdId;

    private String stdName;

    private List<Score> scoreList = new ArrayList<>();

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
