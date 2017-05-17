package com.biz.std.repository;

import com.biz.std.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by king on 2017/5/10.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Page<Student> findAll(Pageable pageable);

    Student findById(Integer id);
}
