package com.example.yongqi.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yongqi.demo.R;
import com.example.yongqi.demo.adapter.AAdapter;
import com.example.yongqi.demo.model.AModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongqi on 2018/3/4.
 */

public class AFragment extends Fragment{

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_a,null);

        recyclerView = view.findViewById(R.id.recycler);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        AAdapter adapter = new AAdapter();
        recyclerView.setAdapter(adapter);

        List<AModel> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new AModel());

        }

        adapter.setNewData(list);
    }
}
