package com.example.day02_annotation01;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.Field;
/**
 * 注解解析
 * */
public class InAnnotationView {
    public static void bind(Object o){
        try {
            parse(o);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parse(Object o) throws Exception {
        Class<?> aClass = o.getClass();
        View view = null;
        Field[] fields = aClass.getDeclaredFields();
        for(Field field:fields){
            //获取id
            if(field.isAnnotationPresent(InAnnotation.class)){
                InAnnotation annotation = field.getAnnotation(InAnnotation.class);
                int id = annotation.value();
                if(id<0){
                    throw new Exception("error");
                }else{
                    field.setAccessible(true);
                    if(o instanceof View){
                        view = ((View) o).findViewById(id);
                    }else if(o instanceof Activity){
                        view = ((Activity)o).findViewById(id);
                    }
                    field.set(o,view);
                }
                //获取点击
            }else if(field.isAnnotationPresent(BtnAnnotation.class)) {
                BtnAnnotation annotation = field.getAnnotation(BtnAnnotation.class);
                int id = annotation.value();
                if (id < 0) {
                    throw new Exception("error");
                } else {
                    field.setAccessible(true);
                    if (o instanceof View) {
                        view = ((View) o).findViewById(id);
                    } else if (o instanceof Activity) {
                        view = ((Activity) o).findViewById(id);
                    }
                    view.setOnClickListener((View.OnClickListener) o);
                    field.set(o, view);
                }
            }
        }
    }
}
