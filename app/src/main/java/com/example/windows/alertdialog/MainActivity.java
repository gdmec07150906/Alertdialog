package com.example.windows.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.textView);
        Button btn1=(Button) findViewById(R.id.button);
        Button btn2=(Button) findViewById(R.id.button2);
        Button btn3=(Button) findViewById(R.id.button3);
        Button btn4=(Button) findViewById(R.id.button4);
        Button btn5=(Button) findViewById(R.id.button5);
        Button btn6=(Button) findViewById(R.id.button6);
        Button btn7=(Button) findViewById(R.id.button7);

        OnClickListener ltn=new OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        btn1.setOnClickListener(ltn);
        btn2.setOnClickListener(ltn);
        btn3.setOnClickListener(ltn);
        btn4.setOnClickListener(ltn);
        btn5.setOnClickListener(ltn);
        btn6.setOnClickListener(ltn);
        btn7.setOnClickListener(ltn);

    }
    private void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定要退出么？");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确认",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("喜好");
        dialog.setMessage("你喜欢以下什么运动？");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="棒球";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="足球";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="篮球";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"棒球",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"篮球",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"足球",listener);
        dialog.show();
    }
    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你喜欢运动么?");
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的回答是:"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"棒球","篮球","足球"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListener=new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,mListener);
        dialog=builder.create();
        dialog.setTitle("多选");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你喜欢:";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"棒球","篮球","足球"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener=new DialogInterface.OnClickListener(){


            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    if(i!=which){
                        bSelect[i]=false;
                    }else{
                        bSelect[i]=true;


                    }
                }

            }

        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListener);
        dialog=builder.create();
        dialog.setTitle("单选");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你喜欢:";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"棒球","篮球","足球"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener=new DialogInterface.OnClickListener(){


            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你喜欢:"+item[which];
                tv1.setText(str);
            }

        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sListener);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();



    }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.use_defined,null);
        final EditText tEdit= (EditText) layout.findViewById(R.id.et);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局：你喜欢什么运动呢?");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你说了你喜欢:"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
}
