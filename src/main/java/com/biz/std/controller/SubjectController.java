package com.biz.std.controller;

import com.biz.std.common.PageBean;
import com.biz.std.service.GradeService;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.SubjectFormVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by king on 2017/5/14.
 */
@Controller
@RequestMapping("subject")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @RequestMapping("/toSubjectForm/{pageNum}")
    public ModelAndView goSubjectForm(@PathVariable("pageNum") int pageNum){
        ModelAndView modelAndView = new ModelAndView("subjectForm");
        PageBean<SubjectFormVo> pageBean = subjectService.listSubject(pageNum);
        modelAndView.addObject("pageBean",pageBean);
        return modelAndView;
    }

    @RequestMapping("/toSubjectForm")
    public ModelAndView goSubjectForm(){
        int pageNum = 0;
        ModelAndView modelAndView = new ModelAndView("subjectForm");
        PageBean<SubjectFormVo> pageBean = subjectService.listSubject(pageNum);
        modelAndView.addObject("pageBean",pageBean);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView deleteSubject(Integer id){
        subjectService.deleteSubjectById(id);
        return new ModelAndView("redirect:/subject/toSubjectForm");
    }

    @RequestMapping("/add")
    public ModelAndView addSubject(String name){
        subjectService.addSubject(name);
        return new ModelAndView("redirect:/subject/toSubjectForm");
    }
}
