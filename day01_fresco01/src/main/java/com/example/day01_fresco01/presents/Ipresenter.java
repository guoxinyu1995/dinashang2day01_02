package com.example.day01_fresco01.presents;

import com.example.day01_fresco01.util.ICallBack;

import java.util.Map;

public interface Ipresenter {
    void startRequest(String url, Map<String,String> map, Class clazz);
}
