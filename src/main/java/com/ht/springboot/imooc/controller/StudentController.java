package com.ht.springboot.imooc.controller;

import com.ht.springboot.imooc.dto.Result;
import com.ht.springboot.imooc.entity.Student;
import com.ht.springboot.imooc.service.StudentService;
import com.ht.springboot.imooc.utils.ResultUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @USER Min
 * @DATE 2018/3/8
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get1")
    public Student findByName(@RequestParam(value = "name",required = false,defaultValue = "zhangsan")String name){
        return studentService.findByName(name);
    }

    @GetMapping("/get2")
    public String get(){
        return "aaa";
    }

    @GetMapping("/get3/{id}")
    public Student findById(@PathVariable("id")Integer id){
        return studentService.findById(id).get();
    }

    @GetMapping("/get4")
    public void testTransactional(){
        studentService.insertTwoStudent();
    }

    @GetMapping("/get5")
    public Result<Student> save(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(studentService.save(student));
    }

    @GetMapping("/get6/{id}")
    public void test(@PathVariable("id")Integer id) throws Exception {
         studentService.findOne(id);
    }

}
