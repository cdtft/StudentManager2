package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.vo.ScoreFormVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by king on 2017/5/14.
 */
@Service
public class ScoreServiceImpl implements ScoreService{

    @Resource
    private ScoreRepository scoreRepository;

    @Resource
    private StudentRepository studentRepository;

    @Override
    public ScoreFormVO findByStdId(Integer stdId) {
        List<Score> scoreList = scoreRepository.findByStudent_Id(stdId);
        ScoreFormVO scoreFormVO = new ScoreFormVO();
        scoreFormVO.setScoreList(scoreList);
        Student student = studentRepository.findById(stdId);
        scoreFormVO.setStdName(student.getName());
        scoreFormVO.setStdId(stdId);
        return scoreFormVO;
    }

    @Override
    public void updateScore(Integer stdId, Map<String, String> map) {
        Set<String> subjectNameSet = map.keySet();
        for(String s : subjectNameSet){
            Score objScore = scoreRepository.findBySubject_NameAndStudent_Id(s, stdId);
            Float f = Float.parseFloat(map.get(s));
            objScore.setScore(f);
            scoreRepository.save(objScore);
        }
    }
}
