package com.example.selfhelpcity.adapter;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.bean.Collection;


import comenjoy.com.imageloadlibrary.GlideUtil;

public class CollectionAdapter extends BaseQuickAdapter<Collection.DataBean, BaseViewHolder> {


    public CollectionAdapter() {
        super(R.layout.items_my_collection);
    }


    @Override
    protected void convert(BaseViewHolder helper, Collection.DataBean item) {
        GlideUtil.getInstance().loadImage(mContext, Api.BASE_URL + "/images/" + item.getPicture(), R.mipmap.bsd, helper.getView(R.id.items_release_img));
        helper.setText(R.id.items_community_address, item.getAddress());
        helper.setText(R.id.items_roommate_standard, item.getJianjie());
    }
}
