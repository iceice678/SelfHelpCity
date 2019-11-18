package com.example.selfhelpcity.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_create_account)
    TextView tvCreateAccount;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle bundle) {

    }

    @Override
    protected void initView() {
        TextChange textChange = new TextChange();
        etAccount.addTextChangedListener(textChange);
        etPassword.addTextChangedListener(textChange);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void destroy() {

    }

    @OnClick({R.id.tv_login, R.id.tv_create_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.tv_create_account:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            default:
                break;
        }
    }


    // EditText监听器
    class TextChange implements TextWatcher {

        @Override
        public void afterTextChanged(Editable arg0) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

        }

        @Override
        public void onTextChanged(CharSequence cs, int start, int before,
                                  int count) {
            boolean sign2 = etPassword.getText().length() > 0;
            boolean sign = etAccount.getText().length() > 0;
            if (sign2 & sign) {
                tvLogin.setEnabled(true);
                tvLogin.setTextColor(Color.parseColor("#000000"));
            }
            // 在layout文件中，对Button的text属性应预先设置默认值，否则刚打开程序的时候Button是无显示的
            else {
                tvLogin.setEnabled(false);
                tvLogin.setTextColor(Color.parseColor("#66FFFFFF"));
            }
        }

    }
}
