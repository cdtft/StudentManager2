package com.biz.std.util;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.vo.GradeFormVO;
import com.biz.std.vo.SubjectFormVo;
import com.biz.std.vo.StudentFormVo;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by king on 2017/5/12.
 */
public class Po2VoUtil {
    public static StudentFormVo student2StudentVo(Student student) {
        StudentFormVo studentFormVo = new StudentFormVo();
        studentFormVo.setId(student.getId());
        if (StringUtils.isNotEmpty(student.getName())) {
            studentFormVo.setName(student.getName());
        }
        if (StringUtils.isNotEmpty(student.getGender())) {
            studentFormVo.setGender(student.getGender());
        }
        studentFormVo.setAddr(student.getAddr());
        if (student.getBirthday() != null) {
            studentFormVo.setBirthday(student.getBirthday());
        }
        if (student.getGrade() != null) {
            studentFormVo.setGradeName(student.getGrade().getName());
        }
        Set<Score> scores = student.getScores();
        List<String> subjectName = new ArrayList<>();
        int totalScore = 0;
        for (Score objScore : scores) {
            if (objScore.getScore() != null) {
                totalScore += objScore.getScore();
            }
            if(objScore.getSubject()!=null) {
                subjectName.add(objScore.getSubject().getName());
            }
        }
        studentFormVo.setTotalScore(totalScore);
        studentFormVo.setSubjectList(subjectName);
        int result = 0;
        if (student.getBirthday() != null) {
            Date start = new Date();
            Date end = student.getBirthday();
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(start);
            c2.setTime(end);
            int year1 = c1.get(Calendar.YEAR);
            int year2 = c2.get(Calendar.YEAR);
            result = Math.abs(year1 - year2);
        }
        studentFormVo.setAge(result);
        return studentFormVo;
    }

    public static SubjectFormVo subject2SubjectFormVo(Subject subject) {
        SubjectFormVo gradeFormVo = new SubjectFormVo();
        gradeFormVo.setId(subject.getId());
        gradeFormVo.setName(subject.getName());
        return gradeFormVo;
    }

    public static GradeFormVO grade2GradeFormVo(Grade grade) {
        GradeFormVO gradeFormVO = new GradeFormVO();
        gradeFormVO.setId(grade.getId());
        gradeFormVO.setName(grade.getName());
        gradeFormVO.setStdNum(grade.getStudents().size());
        return gradeFormVO;
    }
}
