package com.biz.std.repository;

import com.biz.std.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by king on 2017/5/14.
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer>{

    Page<Subject> findAll(Pageable pageable);

    Subject findByName(String name);

    List<Subject> findAll();
}
