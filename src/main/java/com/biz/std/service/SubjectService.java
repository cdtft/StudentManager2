package com.biz.std.service;

import com.biz.std.common.PageBean;
import com.biz.std.model.Subject;
import com.biz.std.vo.SubjectFormVo;

import java.util.List;

/**
 * Created by king on 2017/5/14.
 */
public interface SubjectService {

    PageBean<SubjectFormVo> listSubject(int currentPage);

    void deleteSubjectById(Integer id);

    void addSubject(String name);

    List<Subject> findAll();

}
