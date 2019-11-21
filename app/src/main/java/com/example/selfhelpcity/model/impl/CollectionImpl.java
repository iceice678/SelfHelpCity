package com.example.selfhelpcity.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.bean.Collection;
import com.example.selfhelpcity.bean.MyRelease;
import com.example.selfhelpcity.model.biz.ICollectionBiz;
import com.example.selfhelpcity.model.listener.CallbackListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class CollectionImpl implements ICollectionBiz {
    @Override
    public void getInfo(CallbackListener<Collection> listener) {
        OkHttpUtils
                .post()
                .addParams("user_id", String.valueOf(Constant.USER_ID))
                .url(Api.GET_ALL_MY_ATTENTION)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.failed(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("CollectionImpl", response);
                        if (!response.isEmpty()) {
                            Collection collection = JSON.parseObject(response, Collection.class);
                            listener.success(collection);
                        }
                    }
                });
    }
}
