package com.example.yongqi.demo.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yongqi.demo.R;
import com.example.yongqi.demo.model.AModel;
import com.example.yongqi.demo.model.PackageInfoBean;

/**
 * Created by yongqi on 2018/3/4.
 */

public class PackageInfoAdapter extends BaseQuickAdapter<PackageInfoBean,BaseViewHolder>{

    public PackageInfoAdapter() {
        super(R.layout.item_package_info);
    }

    @Override
    protected void convert(BaseViewHolder helper, PackageInfoBean item) {

        ImageView appIcon = helper.getView(R.id.app_icon);

        appIcon.setImageDrawable(item.getAppIcon());

        helper.setText(R.id.app_name,item.getAppName());
        helper.setText(R.id.package_name,item.getAppPackageName());

    }
}
