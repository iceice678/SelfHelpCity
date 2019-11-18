package com.example.selfhelpcity.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.comenjoysoft.baselibrary.util.SPUtils;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.services.KeepLiveService;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

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
                            if ( SPUtils.getInstance(SplashActivity.this).getBoolean(Constant.SP_KEY_FIRST_LAUNCH, true) ) {
                                SPUtils.getInstance(SplashActivity.this).put(Constant.SP_KEY_FIRST_LAUNCH, false);
                                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                                finish();
                                overridePendingTransition(R.anim.enter_alpha, R.anim.exit_alpha);
                            } else {
                                String password = SPUtils.getInstance(getApplicationContext()).getString(Constant.SP_KEY_WALLET_ADDRESS, "");
                                if ( !password.isEmpty() ) {
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

    }

    @Override
    protected void destroy() {

    }
}
