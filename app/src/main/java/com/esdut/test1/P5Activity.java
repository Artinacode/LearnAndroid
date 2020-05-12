package com.esdut.test1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class P5Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private String hobbys;
    private TextView hobby;

    @Override
    public void onBackPressed() {
       AlertDialog.Builder builder =  new AlertDialog.Builder(this);
       builder.setIcon(R.mipmap.ic_launcher)
               .setTitle("普通对话框")
               .setMessage("是否退出")
               .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        P5Activity.this.finish();
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p8_checkbox);

        Toast.makeText(this,"吐司消息实验",Toast.LENGTH_LONG).show();



        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);
        hobby = findViewById(R.id.hobby);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        hobbys = new String();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String text = buttonView.getText().toString();
        if(isChecked){
            //be chosen
//            if(!hobbys.contains(text)){
                hobbys = hobbys + text;
                hobby.setText(hobbys);
//            }
        }else{
            //not be chosen
//            if(hobbys.contains(text)){
                hobbys = hobbys.replace(text,"");
                hobby.setText(hobbys);
//            }
        }
    }
}
// ---------------------P7------------------------------------------------
//public class P5Activity extends AppCompatActivity {
//    private RadioGroup radioGroup;
//    private TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.p7_radiobutton);
//        RadioGroup radioGroup = findViewById(R.id.rdg);
//        final TextView textView = findViewById(R.id.tv);
////            匿名内部类
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.man){
//                    textView.setText("您的性别为男");
//                }else{
//                    textView.setText("您的性别为女");
//                }
//
//            }
//        });
//    }
//}
