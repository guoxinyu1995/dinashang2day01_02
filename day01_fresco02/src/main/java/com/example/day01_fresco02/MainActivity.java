package com.example.day01_fresco02;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.AbstractCollection;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView draweeView1;
    private SimpleDraweeView draweeView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //获取资源id
        draweeView1 = findViewById(R.id.simpl1);
        draweeView2 = findViewById(R.id.simpl2);
        Uri uri = Uri.parse("res:///"+R.drawable.tu2);
        draweeView2.setImageURI(uri);
        showUrlBlur(draweeView1,"res:///"+R.drawable.tu1,100,1);
    }
    public void showUrlBlur(SimpleDraweeView draweeView,String url,int iterstions,int blurRadius){
        try {
            Uri uri = Uri.parse(url);
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setPostprocessor(new IterativeBoxBlurPostProcessor(iterstions,blurRadius))
                    .build();
            AbstractDraweeController collection  = Fresco.newDraweeControllerBuilder()
                    .setOldController(draweeView.getController())
                    .setImageRequest(request)
                    .build();
            draweeView.setController(collection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
