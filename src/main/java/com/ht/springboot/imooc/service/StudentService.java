package com.ht.springboot.imooc.service;

import com.ht.springboot.imooc.entity.Student;
import com.ht.springboot.imooc.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @USER Min
 * @DATE 2018/3/8
 */
public interface StudentService extends StudentRepository {
    public void insertTwoStudent();
    public void findOne(Integer id) throws Exception;
}
