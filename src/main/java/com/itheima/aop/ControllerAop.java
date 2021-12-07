package com.itheima.aop;

import com.itheima.pojo.log.MethodLogInfo;
import com.itheima.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Aspect
@Component
public class ControllerAop {
    @Autowired
    private LogService logService;
    @Autowired
    private HttpServletRequest request;

    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object log(ProceedingJoinPoint pjp){


        Long userId = (Long) pjp.getArgs()[0];      //args[0]为用户id
        Date start = null;    //开始时间变量
        Date end = null;      //结束时间变量
        Object proceed = null;
        try {

            start = new Date();    //获取开始时间
            proceed = pjp.proceed();
            end = new Date();      //获取结束时间

        } catch (Throwable throwable) {
            throw new Exception();
        } finally {
            String method = request.getMethod();         //请求方法
            String remoteAddr = request.getRemoteAddr(); //用户ip地址
            long methodTime = end.getTime() - start.getTime();//计算执行时间
            MethodLogInfo methodLogInfo = new MethodLogInfo(null,userId ,method, methodTime, start, end, remoteAddr);
            logService.log(methodLogInfo);

            return proceed;
        }
    }

}
