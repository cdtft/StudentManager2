package com.biz.std.repsoitory;

import com.biz.std.model.Score;
import com.biz.std.repository.ScoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by king on 2017/5/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml","classpath:SpringMVC.xml"})
public class TestScoreRepository {

    @Resource
    private ScoreRepository scoreRepository;

    @Test
    public void testFindBySubject_Name(){
        List<Score> scoreList = scoreRepository.findBySubject_Name("java");
    }

    @Test
    public void indBySubject_NameAndStudent_Id(){
        Score score = scoreRepository.findBySubject_NameAndStudent_Id("java",1);
        System.out.println(score);
    }
}
