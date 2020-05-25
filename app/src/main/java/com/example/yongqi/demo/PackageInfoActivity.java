package com.example.yongqi.demo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yongqi.demo.adapter.PackageInfoAdapter;
import com.example.yongqi.demo.model.PackageInfoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yongqi on 2018/3/15.
 */

public class PackageInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    private PackageInfoAdapter adapter;

    private TextView get;

    private EditText search;
    private LinearLayout loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_info);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler);
        get = findViewById(R.id.get);

        search = findViewById(R.id.search);

        loading = findViewById(R.id.layout_loading);

        get.setOnClickListener(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbar.setTitle("安装应用信息");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PackageInfoAdapter();

        recyclerView.setAdapter(adapter);


        /*new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.obj = getPackage();
                handler.sendMessage(msg);
            }
        }).start();*/

        rx();

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter mAdapter, View view, int position) {
                copy(adapter.getItem(position).getAppPackageName());

            }
        });


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(TextUtils.isEmpty(charSequence)){
                    adapter.setNewData(appList);
                }else{
                    if(searchList == null){
                        searchList = new ArrayList<>();
                    }
                    searchList.clear();
                    for (PackageInfoBean info:appList) {
                        if(info.getAppName().contains(charSequence)){
                            searchList.add(info);
                        }
                    }
                    adapter.setNewData(searchList);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void rx(){
        Observable.create(new ObservableOnSubscribe<List<PackageInfoBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<PackageInfoBean>> emitter) throws Exception {


                emitter.onNext(getPackage());
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PackageInfoBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<PackageInfoBean> packageInfoBeans) {
                loading.setVisibility(View.GONE);
                adapter.setNewData(packageInfoBeans);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private List<PackageInfoBean>  appList,searchList;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loading.setVisibility(View.GONE);
            appList = (List<PackageInfoBean>) msg.obj;
            adapter.setNewData(appList);
        }
    };

    private List<PackageInfoBean> getPackage(){
        List<PackageInfoBean> list = new ArrayList<>();

        PackageManager manage = this.getPackageManager();
        List<PackageInfo> packageList = manage.getInstalledPackages(0);

        Log.e("XS",packageList.size() + "个应用---");
        for (PackageInfo info:packageList) {
            PackageInfoBean bean = new PackageInfoBean();
            bean.setAppIcon(info.applicationInfo.loadIcon(manage));

            bean.setAppName(manage.getApplicationLabel(info.applicationInfo).toString());

            bean.setAppPackageName(info.applicationInfo.packageName);

            list.add(bean);
        }

        return list;
    }

    @Override
    public void onClick(View view) {
        List<PackageInfoBean> list = getPackage();

        //adapter.setNewData(list);

        //Log.e("XS",list.size() + "个应用");
    }


    private void copy(String msg){
        ClipboardManager manage = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        ClipData data = ClipData.newPlainText("PackageName",msg);
        manage.setPrimaryClip(data);
    }
}
