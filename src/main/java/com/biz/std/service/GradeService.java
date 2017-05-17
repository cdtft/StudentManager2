package com.biz.std.service;

import com.biz.std.common.PageBean;
import com.biz.std.model.Grade;
import com.biz.std.vo.GradeFormVO;
import com.biz.std.vo.SubjectFormVo;

import java.util.List;

/**
 * Created by king on 2017/5/13.
 */
public interface GradeService {

    List<Grade> findAll();

    PageBean<GradeFormVO> listGrade(int current);

    void deleteGrade(Integer id);

    void addGrade(String gradeName);
}
