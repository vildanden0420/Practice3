package com.example.user.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.user.myapplication.R.id.nextAct;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    TextView t1;
    LinearLayout linearLayout;
    int degreeChic = 0, degreePasta =0;
    int i =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요");
        iv = (ImageView)findViewById(R.id.imageView);
        t1 = (TextView)findViewById(R.id.textView1);
        linearLayout = (LinearLayout)findViewById(R.id.layout);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.nextAct){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.menuBlue){
            linearLayout.setBackgroundColor(Color.BLUE);
        }else if(item.getItemId() == R.id.menuRed){
            linearLayout.setBackgroundColor(Color.RED);
        }else if(item.getItemId() == R.id.menuYellow){
            linearLayout.setBackgroundColor(Color.YELLOW);
        }

        if(item.getItemId() == R.id.menu2){
            if(i == 0) {
                degreeChic = degreeChic + 30;
                iv.setRotation(degreeChic);
            } else{
                degreePasta = degreePasta + 30;
                iv.setRotation(degreePasta);
            }
        }

        if(item.getItemId() == R.id.showTitle){
            if(item.isChecked()){
                item.setChecked(false);
                t1.setVisibility(View.INVISIBLE);
            }else{
                item.setChecked(true);
                t1.setVisibility(View.VISIBLE);
            }
        }

        if(item.getItemId() == R.id.expand){
            if(item.isChecked()){
                item.setChecked(false);

                iv.setScaleX(1.0f);
                iv.setScaleY(1.0f);

            }else{
                item.setChecked(true);

                iv.setScaleX(2.0f);
                iv.setScaleY(2.0f);
            }
        }

        if(item.getItemId() == R.id.chicken){
            item.setChecked(true);
            stateReset("chicken");


        } else if(item.getItemId() == R.id.pasta){
            item.setChecked(true);
            stateReset("pasta");
        }

        return super.onOptionsItemSelected(item);
    }

    public void stateReset (String state){
        degreeChic =0;
        degreePasta =0;
        iv.setRotation(0);
        iv.setVisibility(View.VISIBLE);



        if(state =="chicken"){

            i= 0;
            iv.setImageResource(R.drawable.friedchicken);
            t1.setText("겁나 맛있는 치킨");
        }else{
            i=1;
            iv.setImageResource(R.drawable.pasta);
            t1.setText("새콤한 스파게티");
        }
    }




}
