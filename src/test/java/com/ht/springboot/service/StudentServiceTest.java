package com.ht.springboot.service;

import com.ht.springboot.imooc.entity.Student;
import com.ht.springboot.imooc.repository.StudentRepository;
import com.ht.springboot.imooc.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @USER Min
 * @DATE 2018/3/9
 */
@RunWith(SpringRunner.class)//底层使用Junit
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findOneTest() throws Exception {
        Student student = studentService.findById(1).get();
        Assert.assertEquals(new String("classes1"),student.getClasses());//期望
    }

}
