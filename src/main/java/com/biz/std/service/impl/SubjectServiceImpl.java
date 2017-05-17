package com.biz.std.service.impl;

import com.biz.std.common.PageBean;
import com.biz.std.model.Score;
import com.biz.std.model.Subject;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.SubjectService;
import com.biz.std.util.Po2VoUtil;
import com.biz.std.vo.SubjectFormVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/14.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectRepository subjectRepository;

    @Resource
    private ScoreRepository scoreRepository;

    @Override
    public PageBean<SubjectFormVo> listSubject(int current) {
        PageBean<SubjectFormVo> pageBean = new PageBean<>();
        List<SubjectFormVo> subjectFormVoList = new ArrayList<>();
        Pageable pageable = new PageRequest(current,10);
        Page<Subject> page = subjectRepository.findAll(pageable);
        List<Subject> subjectList = page.getContent();
        for(Subject s:subjectList){
            List<String> studentNameList = new ArrayList<>();
            List<Score> scoreList = scoreRepository.findBySubject_Name(s.getName());
            SubjectFormVo subjectFormVo = Po2VoUtil.subject2SubjectFormVo(s);
            int totalScore = 0;
            for(Score objScore : scoreList){
                if(objScore.getScore() != null){
                    totalScore += objScore.getScore();
                }
                String studentName = objScore.getStudent().getName();
                studentNameList.add(studentName);
            }
            int avg = 0;
            if(scoreList.size() != 0) {
                avg = totalScore / scoreList.size();
            }
            subjectFormVo.setAvgScore(avg);
            subjectFormVo.setStudentNum(studentNameList.size());
            subjectFormVo.setStdNameList(studentNameList);
            subjectFormVoList.add(subjectFormVo);
        }
        pageBean.setList(subjectFormVoList);
        int currentPage = page.getNumber();
        int pageSize = page.getSize();
        int totalPage = page.getTotalPages();
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    @Override
    public void deleteSubjectById(Integer id) {
        subjectRepository.delete(id);
    }

    @Override
    public void addSubject(String name) {
        Subject subject = subjectRepository.findByName(name);
        if(subject == null){
            Subject s = new Subject();
            s.setName(name);
            subjectRepository.save(s);
        }
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
}
