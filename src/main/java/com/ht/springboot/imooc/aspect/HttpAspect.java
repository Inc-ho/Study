package com.ht.springboot.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @USER Min
 * @DATE 2018/3/9
 */
@Component
@Aspect
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
/*    @Before(value = "execution(public * com.ht.springboot.imooc.controller.StudentController.get(..))")
    public void log(){
        System.out.println("");
    }

    @After(value = "execution(public * com.ht.springboot.imooc.controller.StudentController.get(..))")
    public void log2(){
        System.out.println("");
    }*/

    @Pointcut("execution(public * com.ht.springboot.imooc.controller.StudentController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteHost());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("");
    }
}
