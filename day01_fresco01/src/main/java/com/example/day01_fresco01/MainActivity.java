package com.example.day01_fresco01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.day01_fresco01.adaper.ImageAdaper;
import com.example.day01_fresco01.api.Apis;
import com.example.day01_fresco01.bean.ImageBean;
import com.example.day01_fresco01.presents.PresenterImpl;
import com.example.day01_fresco01.view.Iview;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Iview {

    private PresenterImpl presenter;
    private RecyclerView recyclerView;
    private ImageAdaper adaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PresenterImpl(this);
        initView();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        presenter.startRequest(Apis.URL_IMAGE,map,ImageBean.class);
    }

    private void initView() {
        //获取资源id
        recyclerView = findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        adaper = new ImageAdaper(this);
        recyclerView.setAdapter(adaper);
    }

    @Override
    public void requestData(Object o) {
        if(o instanceof ImageBean){
            ImageBean bean = (ImageBean) o;
            if(bean==null || !bean.isSuccess()){
                Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT ).show();
            }else{
                adaper.setmData(bean.getData());
            }
        }
    }

    @Override
    public void requestFail(Object o) {
        if(o instanceof Exception){
            Exception e = (Exception) o;
            e.printStackTrace();
        }
        Toast.makeText(MainActivity.this,"网络请求失败",Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
