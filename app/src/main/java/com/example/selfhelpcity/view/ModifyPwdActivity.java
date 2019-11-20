package com.example.selfhelpcity.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ModifyPwdActivity extends BaseActivity {
    @BindView(R.id.findpwd_back)
    ImageView findpwdBack;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_new_pwd)
    EditText etNewPwd;
    @BindView(R.id.et_new_confirmpwd)
    EditText etNewConfirmpwd;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    protected int getContentView() {
        return R.layout.activity_modify_pwd;
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


    @OnClick({R.id.findpwd_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.findpwd_back:
                finish();
                break;
            case R.id.tv_confirm:
                break;
            default:
                break;
        }
    }

//    private void getDataFormNet(String username, String password, String confirmPassword, String tel) {
//        OkHttpUtils
//                .post()
//                .addParams("username", username)
//                .addParams("password", password)
//                .addParams("confirm_password", confirmPassword)
//                .addParams("telephone", tel)
//                .url(Api.REGISTER)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        showToast("注册失败");
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        showToast("注册成功");
//                        startActivity(new Intent(ModifyPwdActivity.this, LoginActivity.class));
//                        finish();
////                        ProcessData(response);
//                    }
//
//                });
//    }
}
