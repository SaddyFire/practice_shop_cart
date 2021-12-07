package com.itheima.controller.handler;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    /*@ExceptionHandler
    public Result handlerBusinessException(BusinessException e){
        return new Result(0,e.getMessage(),null);
    }*/
    /*@ExceptionHandler
    public Result handlerException(Exception e){
        return new Result(0,"对不起,系统异常,请稍后再试",null);
    }*/
}
