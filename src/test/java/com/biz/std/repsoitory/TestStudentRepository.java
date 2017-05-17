package com.biz.std.repsoitory;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by king on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml", "classpath:SpringMVC.xml"})
public class TestStudentRepository {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private GradeRepository gradeRepository;
    @Test
    public void testSaveStudent(){
        Student student = new Student();
        Grade grade = gradeRepository.findById(1);
        student.setId(3);
        Date date = new Date();
        student.setBirthday(date);
        student.setName("test");
        student.setGender("男");
        student.setGrade(grade);
        studentRepository.save(student);
    }

    @Test
    public void testFindAllByPage(){
        Pageable pageable = new PageRequest(1,1);
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        int number = page.getNumber();
    }

}
