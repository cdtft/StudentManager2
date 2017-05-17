package com.biz.std.controller;

import com.biz.std.common.PageBean;
import com.biz.std.model.Grade;
import com.biz.std.model.Subject;
import com.biz.std.service.GradeService;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.ScoreFormVO;
import com.biz.std.vo.StudentFormVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;



/**
 * Created by king on 2017/5/10.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private GradeService gradeService;

    @Resource
    private SubjectService subjectService;

    @Resource
    private ScoreService scoreService;

    @RequestMapping("/form")
    public ModelAndView goStudentForm(){
        ModelAndView modelAndView = new ModelAndView("studentForm");
        PageBean studentFormVo = studentService.listStudent();
        List<Grade> gradeList = gradeService.findAll();
        List<Subject> subjectList = subjectService.findAll();
        modelAndView.addObject("studentFormVo",studentFormVo);
        modelAndView.addObject("gradeList", gradeList);
        modelAndView.addObject("subjectList", subjectList);
        return modelAndView;
    }

    @RequestMapping("/save")
    public ModelAndView saveOrUpdateStudent(StudentFormVo studentFormVo){
        ModelAndView modelAndView = new ModelAndView("redirect:/student/form");
        studentService.saveOrUpdateStudent(studentFormVo);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public void deleteStudent(Integer id){
        studentService.deleteStudentById(id);
    }

    @RequestMapping("/toAddStudent")
    public ModelAndView goStudentAdd(){
        ModelAndView modelAndView = new ModelAndView("studentAdd");
        List<Grade> gradeList = gradeService.findAll();
        modelAndView.addObject("gradeList",gradeList);
        return modelAndView;
    }

    @RequestMapping("/selectSubject")
    public ModelAndView selectSubject(Integer id, String name){
        Integer stdId = id;
        studentService.selectSubject(name, id);
        return new ModelAndView("redirect:/student/form");
    }

    @RequestMapping("/toSoreForm/{id}")
    public ModelAndView goScoreForm(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("scoreForm");
        ScoreFormVO scoreFormVO = scoreService.findByStdId(id);
        modelAndView.addObject("scoreFormVo",scoreFormVO);
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam Integer id, @RequestParam MultipartFile file, HttpServletRequest request) {

        if (file != null) {
            String path = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            String fileAlias = id + ".png";
            File targetFile = new File(path, fileAlias);
            targetFile.mkdirs();
            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/student/form");

    }

    @RequestMapping("/pageSkip/{pageNum}")
    public ModelAndView pageSkip(@PathVariable("pageNum") int pageNum){
        ModelAndView modelAndView = new ModelAndView("studentForm");
        PageBean studentFormVo = studentService.skipStudentPage(pageNum);
        List<Grade> gradeList = gradeService.findAll();
        List<Subject> subjectList = subjectService.findAll();
        modelAndView.addObject("studentFormVo",studentFormVo);
        modelAndView.addObject("gradeList", gradeList);
        modelAndView.addObject("subjectList", subjectList);
        return modelAndView;
    }

    @RequestMapping("/toSubjectSelect/{id}")
    public ModelAndView goSubjectSelect(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("subjectSelect");
        modelAndView.addObject("stdId", id);
        List<Subject> subjectList = subjectService.findAll();
        modelAndView.addObject("subjectList",subjectList);
        return modelAndView;
    }
}
