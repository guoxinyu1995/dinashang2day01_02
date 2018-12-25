package com.example.day02_fanshe02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.check_reflex).setOnClickListener(this);
        findViewById(R.id.reflex_with_parameter).setOnClickListener(this);
        findViewById(R.id.reflex_with_no_parameter).setOnClickListener(this);
    }
    private void reflexDemoBean() throws Exception {
        UserBean userBean = new UserBean();
        Class<?> c = Class.forName(userBean.getClass().getCanonicalName());
        //获取所有的变量
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(userBean,"wangwu");
        Object o = name.get(userBean);
        if(o instanceof String){
            String s = String.valueOf(o);
            System.out.println("----------------"+s);
        }
    }
    private void doReflexWithParameter() throws Exception {
        UserBean userBean = new UserBean();
        System.out.println("调用前："+userBean.getName());
        Method method = userBean.getClass().getDeclaredMethod("changeName1", String.class);
        method.setAccessible(true);
        Object o = method.invoke(userBean, "lilililili");
        if(o instanceof String){
            String s = String.valueOf(o);
            System.out.println("----------------"+s);
        }
    }
    private void doReflexWithNoParameter() throws Exception {
        UserBean userBean = new UserBean();
        System.out.println("调用前："+userBean.getName());
        Method initName = userBean.getClass().getDeclaredMethod("initName");
        initName.setAccessible(true);
        initName.invoke(userBean);
        System.out.println("调用hou："+userBean.getName());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_reflex:
                try {
                    reflexDemoBean();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.reflex_with_parameter:
                try {
                    doReflexWithParameter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.reflex_with_no_parameter:
                try {
                    doReflexWithNoParameter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                default:
                    break;
        }
    }
}
