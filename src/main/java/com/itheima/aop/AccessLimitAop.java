package com.itheima.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.itheima.exception.AcquireExecption;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component  //加入容器
@Aspect     //注解aop类
public class AccessLimitAop {
    //设置令牌 100.0代表每秒生成100个令牌
    private RateLimiter limiter = RateLimiter.create(100.0);

    //环绕注解aop
    @Around("@annotation(com.itheima.anno.AccessLimit)")
    public Object arount(ProceedingJoinPoint pjp){

        Object proceed = null;
        //尝试获取获取令牌
        boolean flag = limiter.tryAcquire();
        //若没有获得令牌,则抛出请求异常(异常类详见第4条)
        if(!flag){
            throw new AcquireExecption("系统异常,请稍后重试..");
        }

        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }
}
