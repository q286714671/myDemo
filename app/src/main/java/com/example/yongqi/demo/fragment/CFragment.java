package com.example.yongqi.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yongqi.demo.R;

/**
 * Created by yongqi on 2018/3/4.
 */

public class CFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_,null);
        TextView tag = view.findViewById(R.id.tag);
        tag.setText("我是fargmnet3");
        return view;
    }
}
