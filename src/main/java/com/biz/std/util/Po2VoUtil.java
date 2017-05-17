package com.biz.std.util;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.vo.GradeFormVO;
import com.biz.std.vo.SubjectFormVo;
import com.biz.std.vo.StudentFormVo;

import java.util.*;

/**
 * Created by king on 2017/5/12.
 */
public class Po2VoUtil {
    public static StudentFormVo student2StudentVo(Student student){
        StudentFormVo studentFormVo = new StudentFormVo();
        studentFormVo.setId(student.getId());
        studentFormVo.setName(student.getName());
        studentFormVo.setGender(student.getGender());
        studentFormVo.setAddr(student.getAddr());
        studentFormVo.setBirthday(student.getBirthday());
        studentFormVo.setGradeName(student.getGrade().getName());
        Set<Score> scores = student.getScores();
        List<String> subjectName = new ArrayList<>();
        int totalScore = 0;
        for(Score objScore : scores){
            if(objScore.getScore() != null) {
                totalScore += objScore.getScore();
            }
            subjectName.add(objScore.getSubject().getName());
        }
        studentFormVo.setTotalScore(totalScore);
        studentFormVo.setSubjectList(subjectName);
        Date start = new Date();
        Date end = student.getBirthday();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(start);
        c2.setTime(end);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int result = Math.abs(year1 -year2);
        studentFormVo.setAge(result);
        return studentFormVo;
    }

    public static SubjectFormVo subject2SubjectFormVo(Subject subject){
        SubjectFormVo gradeFormVo = new SubjectFormVo();
        gradeFormVo.setId(subject.getId());
        gradeFormVo.setName(subject.getName());
        return gradeFormVo;
    }

    public static GradeFormVO grade2GradeFormVo(Grade grade){
        GradeFormVO gradeFormVO = new GradeFormVO();
        gradeFormVO.setId(grade.getId());
        gradeFormVO.setName(grade.getName());
        gradeFormVO.setStdNum(grade.getStudents().size());
        return gradeFormVO;
    }
}
