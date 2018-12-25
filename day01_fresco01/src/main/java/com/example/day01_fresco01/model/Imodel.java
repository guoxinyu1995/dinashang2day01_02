package com.example.day01_fresco01.model;

import com.example.day01_fresco01.util.ICallBack;

import java.util.Map;

public interface Imodel {
    void requestData(String url, Map<String,String> map, Class clazz,MyCallBack myCallBack);
}
