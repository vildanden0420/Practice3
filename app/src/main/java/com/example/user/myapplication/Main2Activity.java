package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TabHost tabHost;
    Button bmiButton , b1, b2;
    EditText e1, e2, e3;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");
        init();

    }

    void init(){
        tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI 계산기"));
        tabHost.addTab(tabHost.newTabSpec("B").setContent(R.id.tab2).setIndicator("면적 계산기"));

        e1 = (EditText)findViewById(R.id.height);
        e2 = (EditText)findViewById(R.id.weight);

        t1 = (TextView)findViewById(R.id.showResult);

        bmiButton = (Button)findViewById(R.id.button);

        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputHeight = e1.getText().toString();
                double height = 0;
                if(!inputHeight.equals("")){
                    height = Double.parseDouble(inputHeight);
                }

                String inputWeight = e2.getText().toString();
                double weight = 0;
                if(!inputWeight.equals("")){
                    weight = Double.parseDouble(inputWeight);
                }

                double result = weight/((height*height)/10000);

                if(result < 18.5) {
                    t1.setText("체중미달입니다.");
                }else if(result < 22.9){
                    t1.setText("정상입니다.");
                }else if(result < 24.9){
                    t1.setText("과체중입니다.");
                }else{
                    t1.setText("비만입니다.");
                }
            }
        });

        e3 = (EditText)findViewById(R.id.editText);

        t2 = (TextView)findViewById(R.id.textView2);

        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String input = e3.getText().toString();
                double inputNum = 0;
                if(!input.equals("")){
                    inputNum = Double.parseDouble(input);
                }
                double result = inputNum * 3.305785;
                t2.setText(""+result);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String input = e3.getText().toString();
                double inputNum = 0;
                if(!input.equals("")){
                    inputNum = Double.parseDouble(input);
                }
                double result = inputNum * 0.3025;
                t2.setText(""+result);
            }
        });
    }
}
