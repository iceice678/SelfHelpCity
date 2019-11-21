package com.example.selfhelpcity.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.bean.MyRelease;
import com.example.selfhelpcity.model.biz.IReleaseBiz;
import com.example.selfhelpcity.model.listener.CallbackListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class ReleaseImpl implements IReleaseBiz {
    @Override
    public void getReleaseInfo(int id, CallbackListener<MyRelease> listener) {
        OkHttpUtils
                .post()
                .url(Api.GET_MY_PUBLISHED_LISTINGS)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.failed(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("Releaseljy", response);
                        if (!response.isEmpty()) {
                            MyRelease myRelease = JSON.parseObject(response, MyRelease.class);
                            listener.success(myRelease);
                        }
                    }
                });
    }

    @Override
    public void addReleaseInfo() {

    }
}
