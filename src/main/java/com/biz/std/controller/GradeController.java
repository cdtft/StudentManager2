package com.biz.std.controller;

import com.biz.std.common.PageBean;
import com.biz.std.model.Grade;
import com.biz.std.service.GradeService;
import com.biz.std.vo.GradeFormVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by king on 2017/5/14.
 */
@Controller
@RequestMapping("grade")
public class GradeController {

    @Resource
    private GradeService gradeService;

    @RequestMapping("/toGradeForm/{currentPage}")
    public ModelAndView goGradeForm(@PathVariable("currentPage") int currentPage){
        ModelAndView modelAndView = new ModelAndView("gradeForm");
        PageBean<GradeFormVO> pageBean = gradeService.listGrade(currentPage);
        modelAndView.addObject("pageBean",pageBean);
        return modelAndView;
    }

    //js控制界面自动刷新
    @RequestMapping("/delete")
    public void deleteGrade(Integer id){
        gradeService.deleteGrade(id);
    }

    @RequestMapping("/add")
    public ModelAndView addGrade(String gradeName){
        ModelAndView modelAndView = new ModelAndView("redirect:/grade/toGradeForm/0");
        gradeService.addGrade(gradeName);
        return modelAndView;
    }
}
