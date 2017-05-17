package com.biz.std.service;

import com.biz.std.common.PageBean;
import com.biz.std.vo.StudentFormVo;

/**
 * Created by king on 2017/5/11.
 */
public interface StudentService {
    PageBean<StudentFormVo> listStudent();

    void saveOrUpdateStudent(StudentFormVo studentFormVo);

    void deleteStudentById(Integer id);

    void selectSubject(String subjectName, Integer studentId);

    PageBean<StudentFormVo> skipStudentPage(int pageNum);
}
