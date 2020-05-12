package com.esdut.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private int textsize = 0;
    private int[] textSizeArr = {10,20,30};
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button bt1 = findViewById(R.id.bt);
        tv1 = findViewById(R.id.ad);
        bt1.setOnClickListener(this);


        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.esdut.test1.ACTION_START");
                intent.addCategory("com.esdut.test1.MY_CATEGORY");
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://baidu.com"));
                startActivity(intent);
            }
        });
//        我负责跳转
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.esdut.test1.Action05");

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("单选对话框")
                .setSingleChoiceItems(new String[]{"小","中","大"},textsize,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textsize = which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = textSizeArr[textsize];
                        tv1.setTextSize(size);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}