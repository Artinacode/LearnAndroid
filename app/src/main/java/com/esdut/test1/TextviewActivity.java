package com.esdut.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TextviewActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p4_button);
        button1 =  findViewById(R.id.button1);
        button2 =  findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText("按钮2被点击（匿名内部类）");
            }
        });
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    public void click1(View view) {
        button1.setText("按钮1被点击");
    }

    @Override
    public void onClick(View v) {
        button3.setText("按钮3被点击（实现接口）");
    }
}
