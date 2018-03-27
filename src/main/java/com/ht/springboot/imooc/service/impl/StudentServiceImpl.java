package com.ht.springboot.imooc.service.impl;

import com.ht.springboot.imooc.entity.Student;
import com.ht.springboot.imooc.enums.ResultEnum;
import com.ht.springboot.imooc.exception.SpringBootException;
import com.ht.springboot.imooc.repository.StudentRepository;
import com.ht.springboot.imooc.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @USER Min
 * @DATE 2018/3/8
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public <S extends Student> S save(S s) {
        return studentRepository.save(s);
    }

    @Override
    public <S extends Student> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Student> findById(Integer integer) {
        return studentRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Student> findAll() {
        return null;
    }

    @Override
    public Iterable<Student> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void deleteAll(Iterable<? extends Student> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED,rollbackFor=Exception.class)
    public void insertTwoStudent(){
        Student s1 = new Student();
        s1.setClasses("classes2");
        s1.setName("a");
        studentRepository.save(s1);
        System.out.println("执行了！");

        Student s = new Student();
        s.setClasses("classes2");
        s.setName("aaaaaaaaaaaaaaaaaaaaaab");
        studentRepository.save(s);
    }

    @Override
    public void findOne(Integer id) throws Exception {
        Student student = studentRepository.findById(id).get();
        if(student.getClasses().equals("classes2")){
           /* throw new SpringBootException(101,"错误1");*/
           throw new SpringBootException(ResultEnum.ERROR_1);
        }else if(student.getClasses().equals("classes1")){
//            throw new SpringBootException(102,"错误2");
            throw new SpringBootException(ResultEnum.ERROR_2);
        }else{
            throw new Exception();
        }

    }
}
