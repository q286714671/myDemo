package com.example.yongqi.demo;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.yongqi.demo.studyretrofit.StudyActivity;


/**
 * Created by yongqi on 2017/12/2.
 */

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        //toolbar.setTitle("这是个标题");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setOnMenuItemClickListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        //android.hardware.Camera.open();

        /*SlidrConfig config = new SlidrConfig.Builder()
                .edge(true)
                .build();
        Slidr.attach(this, config);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.setting,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId() == R.id.action_webView){
            Intent intent = new Intent(this,WebViewActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.anim){
            Intent intent = new Intent(this,AddAnimActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.custom){
            Intent intent = new Intent(this,CustomViewActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.okhttp){
            Intent intent = new Intent(this,StudyActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.tablayout){
            Intent intent = new Intent(this,TabLayoutActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.package_info){
            Intent intent = new Intent(this,PackageInfoActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.rxjava){
            Intent intent = new Intent(this,RxjavaActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.view_1){
            Intent intent = new Intent(this,View1Activity.class);
            startActivity(intent);
        }
        return true;
    }
}
