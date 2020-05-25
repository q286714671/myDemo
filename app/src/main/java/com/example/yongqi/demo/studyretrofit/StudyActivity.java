package com.example.yongqi.demo.studyretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.yongqi.demo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yongqi on 2018/2/27.
 */

public class StudyActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView get,post,content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        get = findViewById(R.id.get);
        post = findViewById(R.id.post);

        content = findViewById(R.id.content);

        get.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.get){
            final Call<MovieHotBean> getCall = AppStores.service.getIP();

            getCall.enqueue(new Callback<MovieHotBean>() {
                @Override
                public void onResponse(Call<MovieHotBean> call, Response<MovieHotBean> response) {

                    content.setText(response.body().toString());

                    getCall.cancel();
                }

                @Override
                public void onFailure(Call<MovieHotBean> call, Throwable t) {

                    content.setText(t.toString());
                }
            });
        }
    }
}
