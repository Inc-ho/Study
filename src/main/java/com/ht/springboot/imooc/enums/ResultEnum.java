package com.ht.springboot.imooc.enums;

/**
 * @USER Min
 * @DATE 2018/3/9
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ERROR_1(101,"错误1"),
    ERROR_2(102,"错误2"),
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
