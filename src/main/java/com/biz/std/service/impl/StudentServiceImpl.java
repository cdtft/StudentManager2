package com.biz.std.service.impl;

import com.biz.std.common.PageBean;
import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.util.Po2VoUtil;
import com.biz.std.util.Vo2PoUtil;
import com.biz.std.vo.StudentFormVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/11.
 */

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private GradeRepository gradeRepository;

    @Resource
    private ScoreRepository scoreRepository;

    @Resource
    private SubjectRepository subjectRepository;


    @Override
    public PageBean<StudentFormVo> listStudent() {
        Pageable pageable = new PageRequest(0,10);
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        List<StudentFormVo> studentFormVos = new ArrayList<>();
        for(Student s : students){
            StudentFormVo studentFormVo = Po2VoUtil.student2StudentVo(s);
            studentFormVos.add(studentFormVo);
        }
        int totalPages = page.getTotalPages();
        int currentPage = page.getNumber();
        int size = page.getSize();
        PageBean<StudentFormVo> pageBean = new PageBean<>();
        pageBean.setList(studentFormVos);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(size);
        pageBean.setTotalPage(totalPages);
        return pageBean;
    }

    @Override
    public void saveOrUpdateStudent(StudentFormVo studentFormVo) {
        String gradeName = studentFormVo.getGradeName();
        Student student = Vo2PoUtil.StudentVo2Student(studentFormVo);
        Grade grade = gradeRepository.findByName(gradeName);
        student.setGrade(grade);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.delete(id);
    }

    @Override
    public void selectSubject(String subjectName, Integer studentId) {
        Score score = scoreRepository.findBySubject_NameAndStudent_Id(subjectName, studentId);
        if(score == null){
            Score s = new Score();
            s.setStudent(studentRepository.findOne(studentId));
            s.setSubject(subjectRepository.findByName(subjectName));
            scoreRepository.save(s);
        }

    }

    @Override
    public PageBean<StudentFormVo> skipStudentPage(int pageNum) {
        Pageable pageable = new PageRequest(pageNum,10);
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        List<StudentFormVo> studentFormVos = new ArrayList<>();
        for(Student s : students){
            StudentFormVo studentFormVo = Po2VoUtil.student2StudentVo(s);
            studentFormVos.add(studentFormVo);
        }
        int totalPages = page.getTotalPages();
        int currentPage = page.getNumber();
        int size = page.getSize();
        PageBean<StudentFormVo> pageBean = new PageBean<>();
        pageBean.setList(studentFormVos);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(size);
        pageBean.setTotalPage(totalPages);
        return pageBean;
    }

}
