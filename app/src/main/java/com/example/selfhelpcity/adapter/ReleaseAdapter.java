package com.example.selfhelpcity.adapter;


import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.bean.ReleaseBean;

import java.util.List;

public class ReleaseAdapter extends BaseQuickAdapter<ReleaseBean, BaseViewHolder> {

    private Context context;
    private List<String> list;

    public ReleaseAdapter() {
        super(R.layout.items_release);
    }


    @Override
    protected void convert(BaseViewHolder helper, ReleaseBean item) {

    }
}
