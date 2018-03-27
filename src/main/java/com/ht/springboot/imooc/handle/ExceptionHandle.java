package com.ht.springboot.imooc.handle;

import com.ht.springboot.imooc.dto.Result;
import com.ht.springboot.imooc.exception.SpringBootException;
import com.ht.springboot.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @USER Min
 * @DATE 2018/3/9
 * 全局异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)//捕获那个异常类
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof SpringBootException){
            SpringBootException springBootException = (SpringBootException)e;
            return ResultUtil.error(springBootException.getCode(),springBootException.getMessage());
        }else {
            logger.error("[系统异常]{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }


}
