package com.example.selfhelpcity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindPwdActivity extends BaseActivity {
    @BindView(R.id.findpwd_back)
    ImageView findpwdBack;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected int getContentView() {
        return R.layout.activity_findpwd;
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


    @OnClick({R.id.findpwd_back, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.findpwd_back:
                finish();
                break;
            case R.id.tv_login:

                break;
            default:
                break;
        }
    }
}
