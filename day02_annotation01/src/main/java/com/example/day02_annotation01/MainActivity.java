package com.example.day02_annotation01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @InAnnotation(R.id.btn1)
    private Button btn1;
    @BtnAnnotation(value = R.id.btn2)
    //@InAnnotation(R.id.btn2)
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InAnnotationView.bind(this);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn2:
                Toast.makeText(MainActivity.this,"点击2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn1:
                Toast.makeText(MainActivity.this,"点击1",Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }
}
