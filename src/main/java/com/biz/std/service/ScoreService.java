package com.biz.std.service;

import com.biz.std.vo.ScoreFormVO;

import java.util.Map;

/**
 * Created by king on 2017/5/14.
 */
public interface ScoreService {

    ScoreFormVO findByStdId(Integer stdId);

    void updateScore(Integer stdId, Map<String, String> map);
}
