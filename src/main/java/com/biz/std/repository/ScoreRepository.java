package com.biz.std.repository;

import com.biz.std.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2017/5/14.
 */
@Repository
public interface ScoreRepository extends CrudRepository<Score, Integer>{

    List<Score> findBySubject_Name(String subjectName);

    Score findBySubject_NameAndStudent_Id(String subjectName, Integer studentId);

    List<Score> findByStudent_Id(Integer id);

}
