package com.mycompany.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LinearLayout linearLayoutTop;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutTop = (LinearLayout) findViewById(R.id.linearLayoutTop);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
    }

    public void handleRadioButton1(View v) {
        linearLayoutTop.setBackgroundResource(R.drawable.photo1);
    }
    public void handleRadioButton2(View v) {
        linearLayoutTop.setBackgroundResource(R.drawable.photo2);
    }
    public void handleRadioButton3(View v) {
        linearLayoutTop.setBackgroundResource(R.drawable.photo3);
    }

    public void handleButton1(View v){
        frameLayout.removeAllViews();
        Content1 content1 = new Content1(this);
        frameLayout.addView(content1);

        for(int i=1; i<=10; i++) {
            Item item = new Item();
            item.setPhoto(getResources().getIdentifier("member"+i, "drawable", getPackageName()));
            //item.setPhoto(R.drawable.member1);
            item.setTitle("반복 학습이 중요" + i);
            item.setStar(R.drawable.star8);
            item.setContent("안녕!!!!!!!안녕~~~~~~~~~~ 안녕 반복 학습 중요하지요. ");
            content1.addItem(item);
        }
    }

}
