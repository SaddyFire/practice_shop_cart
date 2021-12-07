package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ControllerAdvice + @ResponseBody
 * 把ExecptionAdvice 类变成一个异常处理类
 */

@RestControllerAdvice
public class ExecptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result ex1(Exception ex){

        System.out.println("我执行了Exception...");
        return new Result(0,"服务器异常，请稍后重试");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result ex2(RuntimeException ex){
        System.out.println("我执行了RuntimeException...");
        return new Result(0,"服务器异常，请稍后重试");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result ex3(NullPointerException ex){
        System.out.println("我执行了NullPointerException...");
        return new Result(0,"服务器异常，请稍后重试");
    }

    @ExceptionHandler(AcquireExecption.class)
    @ResponseBody
    public Result ex3(AcquireExecption ex){
        System.out.println("我执行了AcquireExecption...");
        return new Result(0,ex.getMessage());
    }
}