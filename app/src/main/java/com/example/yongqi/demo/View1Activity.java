package com.example.yongqi.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.yongqi.demo.customview.ViewProgress;

/**
 * Created by yongqi on 2018/4/23.
 */

public class View1Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_1);

        final ViewProgress progress =  findViewById(R.id.progress);

        //progress.setDatas();

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setData(90);
            }
        });



        Glide.getPhotoCacheDir(this);

        Glide.get(this).clearDiskCache();

    }
}
