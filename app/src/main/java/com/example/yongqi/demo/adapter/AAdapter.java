package com.example.yongqi.demo.adapter;

import android.content.pm.PackageInfo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yongqi.demo.R;
import com.example.yongqi.demo.model.AModel;

/**
 * Created by yongqi on 2018/3/4.
 */

public class AAdapter extends BaseQuickAdapter<AModel,BaseViewHolder>{

    public AAdapter() {
        super(R.layout.item_a);
    }

    @Override
    protected void convert(BaseViewHolder helper, AModel item) {
        helper.setText(R.id.data,"数据" + helper.getLayoutPosition());
    }
}
