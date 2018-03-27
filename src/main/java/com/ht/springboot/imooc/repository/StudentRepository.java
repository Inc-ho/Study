package com.ht.springboot.imooc.repository;

import com.ht.springboot.imooc.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @USER Min
 * @DATE 2018/3/8
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>{
    public Student findByName(String name);
}
