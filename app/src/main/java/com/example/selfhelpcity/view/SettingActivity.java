package com.example.selfhelpcity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * 设置界面
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.setting_back)
    ImageView settingBack;
    @BindView(R.id.setting_title)
    TextView settingTitle;

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


    @OnClick({R.id.setting_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_back:
                finish();
                break;
           default:
                break;
        }
    }
}
