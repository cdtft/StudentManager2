package com.biz.std.controller;

import com.biz.std.repository.ScoreRepository;
import com.biz.std.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * Created by king on 2017/5/15.
 */
@Controller
@RequestMapping("score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    @RequestMapping("/updateScore/{stdId}")
    public ModelAndView updateScore(@PathVariable("stdId") Integer stdId, @RequestParam Map<String, String> map){
        scoreService.updateScore(stdId, map);
        return new ModelAndView("redirect:/student/form");
    }

}
