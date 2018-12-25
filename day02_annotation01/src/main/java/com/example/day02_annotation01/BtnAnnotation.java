package com.example.day02_annotation01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * 点击用的注解类
 * */
@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface BtnAnnotation {
    int value() default 0;
}
