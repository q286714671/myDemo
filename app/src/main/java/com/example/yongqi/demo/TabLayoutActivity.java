package com.example.yongqi.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yongqi.demo.adapter.FragmentAdapter;
import com.example.yongqi.demo.fragment.AFragment;
import com.example.yongqi.demo.fragment.BFragment;
import com.example.yongqi.demo.fragment.CFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongqi on 2018/3/4.
 */

public class TabLayoutActivity extends AppCompatActivity{

    private TabLayout tabs;

    private ViewPager viewPager;

    private List<Fragment> list = new ArrayList<>();
    private List<String> titles = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        tabs = findViewById(R.id.tabs);

        titles.add("tab1");
        titles.add("tab2");
        titles.add("tab3");

        viewPager = findViewById(R.id.viewpager);

        list.add(new AFragment());
        list.add(new BFragment());
        list.add(new CFragment());

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),list,titles));

        tabs.setupWithViewPager(viewPager);
    }
}
