package com.example.selfhelpcity.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 设置界面
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.setting_back)
    ImageView settingBack;
    @BindView(R.id.setting_title)
    TextView settingTitle;
    @BindView(R.id.tv_loginout)
    TextView tvLoginout;
    @BindView(R.id.toolbar)
    ConstraintLayout toolbar;
    @BindView(R.id.au_gender_ll)
    LinearLayout auGenderLl;
    @BindView(R.id.modify_pwd)
    LinearLayout modifyPwd;

    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init(Bundle bundle) {

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


    private void getDataFormNet() {
        OkHttpUtils
                .post()
                .url(Api.LOGOUT)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showToast("退出登录失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        showToast("退出登录成功");
                        startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                        finish();
//                        ProcessData(response);
                    }

                });
    }


    @OnClick({R.id.setting_back, R.id.tv_loginout, R.id.modify_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_back:
                finish();
                break;
            case R.id.tv_loginout:
                getDataFormNet();
                break;
            case R.id.modify_pwd:
                startActivity(new Intent(SettingActivity.this, ModifyPwdActivity.class));
                break;
            default:
                break;
        }
    }

}
