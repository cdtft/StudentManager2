package com.biz.std.service.impl;

import com.biz.std.common.PageBean;
import com.biz.std.model.Grade;
import com.biz.std.repository.GradeRepository;
import com.biz.std.service.GradeService;
import com.biz.std.util.Po2VoUtil;
import com.biz.std.vo.GradeFormVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/13.
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public PageBean<GradeFormVO> listGrade(int current) {
        PageBean<GradeFormVO> pageBean = new PageBean<>();
        Pageable pageable = new PageRequest(current, 10);
        Page<Grade> page = gradeRepository.findAll(pageable);
        List<Grade> gradeList = page.getContent();
        List<GradeFormVO> gradeFormVOList = new ArrayList<>();
        for(Grade g:gradeList){
            GradeFormVO gradeFormVO = Po2VoUtil.grade2GradeFormVo(g);
            gradeFormVOList.add(gradeFormVO);
        }
        pageBean.setList(gradeFormVOList);
        pageBean.setCurrentPage(page.getNumber());
        pageBean.setTotalPage(page.getTotalPages());
        pageBean.setPageSize(page.getSize());
        return pageBean;
    }

    @Override
    public void deleteGrade(Integer id) {
        gradeRepository.delete(id);
    }

    @Override
    public void addGrade(String gradeName) {
        Grade grade = gradeRepository.findByName(gradeName);
        if(grade == null){
            Grade g =  new Grade();
            g.setName(gradeName);
            gradeRepository.save(g);
        }
    }
}
