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
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

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
                String user = etAccount.getText().toString().trim();
                String pwd = etPassword.getText().toString().trim();
                getDataFormNet(user, pwd);
                break;
            case R.id.tv_create_account:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            default:
                break;
        }
    }

    private void getDataFormNet(String username, String password) {
        OkHttpUtils
                .post()
                .addParams("username", username)
                .addParams("password", password)
                .url(Api.LOGIN)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showToast("登录失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        showToast("登录成功");
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
//                        ProcessData(response);
                    }

                });
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
