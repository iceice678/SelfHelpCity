package com.example.selfhelpcity.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.comenjoysoft.baselibrary.util.SPUtils;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.bean.db.CommuityBean;
import com.example.selfhelpcity.bean.db.peopleBean;
import com.example.selfhelpcity.model.ObjectBox;
import com.example.selfhelpcity.services.KeepLiveService;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;


/**
 * 欢迎页
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init(Bundle bundle) {
        Intent intent = new Intent(SplashActivity.this, KeepLiveService.class);
        startService(intent);
        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE)
                .onGranted(data -> {
                    new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            if (SPUtils.getInstance(SplashActivity.this).getBoolean(Constant.SP_KEY_FIRST_LAUNCH, true)) {
                                SPUtils.getInstance(SplashActivity.this).put(Constant.SP_KEY_FIRST_LAUNCH, false);
                                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                                finish();
                                overridePendingTransition(R.anim.enter_alpha, R.anim.exit_alpha);
                            } else {
                                String password = SPUtils.getInstance(getApplicationContext()).getString(Constant.SP_KEY_WALLET_ADDRESS, "");
                                if (!password.isEmpty()) {
                                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                                    finish();
                                }
                                overridePendingTransition(R.anim.enter_alpha, R.anim.exit_alpha);
                            }
                            finish();
                        }
                    }.sendEmptyMessageDelayed(0, 2000);
                })
                .onDenied(data -> {

                })
                .start();


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
//        OkGo.<String>get(Api.GET_PEOPLE_LIST).execute(new com.lzy.okgo.callback.StringCallback() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                Type type = new TypeToken<List<person>>(){}.getType();
//                List<person> peopleBeans = new Gson().fromJson(response.body(), type);
//                Log.d("ljyljy", "onSuccess: "+peopleBeans.get(0).getPassword());
//            }
//
//            @Override
//            public void onError(Response<String> response) {
//                super.onError(response);
//            }
//        });
        getDataFormNet();
        getDataFormNetCommunity();
    }

    private void getDataFormNetCommunity() {
        OkHttpUtils
                .get()
                .url(Api.GET_COMMUNITY_LIST)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("ljy", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("ljyc", response);
                        processDataCommunity(response);
                    }

                });
    }

    private void processDataCommunity(String response) {
        if (response != null) {
            List<CommuityBean> homeBean = JSON.parseArray(response, CommuityBean.class);
//            result = homeBean.getResult();
//            Log.d("ljy", result.getHot_info().get(0).getName());
            Log.d("ljyc", "ProcessData: " + response);
            ObjectBox.addCommuityToDB(homeBean);
        }
    }

    private void getDataFormNet() {
        OkHttpUtils
                .get()
                .url(Api.GET_PEOPLE_LIST)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("ljy", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("ljy", response);
                        ProcessData(response);
                    }

                });
    }

    private void ProcessData(String json) {
        if (json != null) {
            List<peopleBean> homeBean = JSON.parseArray(json, peopleBean.class);
//            result = homeBean.getResult();
//            Log.d("ljy", result.getHot_info().get(0).getName());
            Log.d("ljy", "ProcessData: " + homeBean.get(0).getAge());
            ObjectBox.addPeopleList(homeBean);
        }


    }

    @Override
    protected void destroy() {

    }
}
