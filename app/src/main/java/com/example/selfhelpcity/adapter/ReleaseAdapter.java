package com.example.selfhelpcity.adapter;


import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.bean.db.CommuityBean;

import java.util.List;

import comenjoy.com.imageloadlibrary.GlideUtil;

public class ReleaseAdapter extends BaseQuickAdapter<CommuityBean, BaseViewHolder> {

    private Context context;
    private List<String> list;

    public ReleaseAdapter() {
        super(R.layout.items_release);
    }


    @Override
    protected void convert(BaseViewHolder helper, CommuityBean item) {
        GlideUtil.getInstance().loadImage(mContext, Api.BASE_URL + "/images/" + item.getPicture(), R.mipmap.bsd, helper.getView(R.id.items_release_img));
        helper.setText(R.id.items_community_address, item.getAddress());
        helper.setText(R.id.items_roommate_standard, item.getJianjie());
        helper.addOnClickListener(R.id.items_collection);
        helper.setChecked(R.id.items_collection, item.isCollection());
    }
}
