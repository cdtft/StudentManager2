package com.biz.std.repsoitory;

import com.biz.std.model.Grade;
import com.biz.std.repository.GradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by king on 2017/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml", "classpath:SpringMVC.xml"})
public class TestGradeRepository {

    @Resource
    private GradeRepository gradeRepository;

    @Test
    public void testFindAll(){
        List<Grade> gradeList = gradeRepository.findAll();
    }
}
