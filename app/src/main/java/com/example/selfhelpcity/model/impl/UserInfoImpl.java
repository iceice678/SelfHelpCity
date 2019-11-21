package com.example.selfhelpcity.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.bean.userInfo;
import com.example.selfhelpcity.model.biz.IUserInfoBiz;
import com.example.selfhelpcity.model.listener.CallbackListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class UserInfoImpl implements IUserInfoBiz {


    @Override
    public void getUserInfo(CallbackListener<userInfo> listener) {
        OkHttpUtils
                .get()
                .url(Api.GET_PERSONAL_INFORMATION)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.failed(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("UserInfoImpl", response);
                        if (!response.isEmpty()) {
                            userInfo userInfo = JSON.parseObject(response, userInfo.class);
                            listener.success(userInfo);
                        }
                    }
                });
    }
}
