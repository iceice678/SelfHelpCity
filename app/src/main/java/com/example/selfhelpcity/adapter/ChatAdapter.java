package com.example.selfhelpcity.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.bean.ChatBean;

import comenjoy.com.imageloadlibrary.GlideUtil;

/**
 * @author ljy
 */
public class ChatAdapter extends BaseQuickAdapter<ChatBean, BaseViewHolder> {

    public ChatAdapter() {
        super(R.layout.items_chat);
    }


    @Override
    protected void convert(BaseViewHolder helper, ChatBean item) {
        GlideUtil.getInstance().loadCircleImage(mContext, R.mipmap.bsd, helper.getView(R.id.fc_iv_icon));
    }
}
