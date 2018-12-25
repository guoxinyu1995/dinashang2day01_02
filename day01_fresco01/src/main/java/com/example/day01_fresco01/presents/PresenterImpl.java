package com.example.day01_fresco01.presents;

import com.example.day01_fresco01.MainActivity;
import com.example.day01_fresco01.model.ModelImpl;
import com.example.day01_fresco01.model.MyCallBack;
import com.example.day01_fresco01.view.Iview;

import java.util.Map;

public class PresenterImpl implements Ipresenter {
    private Iview mIview;
    private ModelImpl model;

    public PresenterImpl(Iview iview) {
        mIview = iview;
        model = new ModelImpl();
    }

    @Override
    public void startRequest(String url, Map<String, String> map, Class clazz) {
        model.requestData(url, map, clazz, new MyCallBack() {
            @Override
            public void setData(Object data) {
                mIview.requestData(data);
            }
        });
    }
    public void onDetach(){
        if (model!=null){
            model = null;
        }
        if(mIview!=null){
            mIview = null;
        }
    }
}
