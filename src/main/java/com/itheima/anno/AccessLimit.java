package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 空注解
 *      元注解 :    标注注解的注解是元注解
 */
@Target(ElementType.METHOD)     //元素类型.在方法上注解
@Retention(RetentionPolicy.RUNTIME)     //持续策略.执行时
public @interface AccessLimit {
}
