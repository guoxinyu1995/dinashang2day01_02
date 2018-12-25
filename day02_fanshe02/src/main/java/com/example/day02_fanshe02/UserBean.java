package com.example.day02_fanshe02;

public class UserBean {
    private String name = "zhangsan";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private void changeName(String str){
        name = str;
    }
    private String changeName1(String str){
        name = str;
        return "dddddd";
    }
    private void initName(){
        name = "lisi";
    }
}
