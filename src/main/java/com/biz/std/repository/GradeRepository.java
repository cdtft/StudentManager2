package com.biz.std.repository;

import com.biz.std.model.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2017/5/12.
 */
@Repository
public interface GradeRepository extends CrudRepository<Grade, Integer> {

    Grade findByName(String name);

    Grade findById(Integer id);

    List<Grade> findAll();

    Page<Grade> findAll(Pageable pageable);
}
