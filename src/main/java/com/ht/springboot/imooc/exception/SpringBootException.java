package com.ht.springboot.imooc.exception;

import com.ht.springboot.imooc.enums.ResultEnum;

/**
 * @USER Min
 * @DATE 2018/3/9
 */
public class SpringBootException extends RuntimeException{

    private Integer code;

    public SpringBootException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
