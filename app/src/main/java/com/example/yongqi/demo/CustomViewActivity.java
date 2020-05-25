package com.example.yongqi.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.yongqi.demo.customview.LineView;
import com.example.yongqi.demo.customview.MyView;

/**
 * Created by yongqi on 2018/1/15.
 */

public class CustomViewActivity extends AppCompatActivity {

    private LinearLayout parent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        parent = findViewById(R.id.ll);

        //parent.addView(new MyView(this));
        parent.addView(new LineView(this));

    }
}
