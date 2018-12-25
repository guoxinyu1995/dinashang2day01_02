package com.example.day02_annotation01;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * 获取id用的注解类
 * */
@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface InAnnotation {
    @IdRes int value();

}
