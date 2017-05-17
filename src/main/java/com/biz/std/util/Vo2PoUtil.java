package com.biz.std.util;

import com.biz.std.model.Student;
import com.biz.std.vo.StudentFormVo;

/**
 * Created by king on 2017/5/12.
 */
public class Vo2PoUtil {
    public static Student StudentVo2Student(StudentFormVo studentFormVo){
        Student student = new Student();
        student.setId(studentFormVo.getId());
        student.setName(studentFormVo.getName());
        student.setGender(studentFormVo.getGender());
        student.setAddr(studentFormVo.getAddr());
        student.setBirthday(studentFormVo.getBirthday());
        return student;
    }
}
