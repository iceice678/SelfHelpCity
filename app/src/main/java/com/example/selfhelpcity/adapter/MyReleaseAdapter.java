package com.example.selfhelpcity.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.bean.MyRelease.DataBean;

import comenjoy.com.imageloadlibrary.GlideUtil;


public class MyReleaseAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {


    public MyReleaseAdapter() {
        super(R.layout.items_my_release);
    }


    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {
        GlideUtil.getInstance().loadImage(mContext, Api.BASE_URL+"/images/"+item.getPicture(), R.mipmap.bsd, helper.getView(R.id.items_release_img));
        helper.setText(R.id.items_community_address, item.getAddress());
        helper.setText(R.id.items_roommate_standard, item.getJianjie());
    }
}
