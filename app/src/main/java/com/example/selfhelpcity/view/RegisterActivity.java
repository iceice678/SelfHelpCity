package com.example.selfhelpcity.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.comenjoysoft.baselibrary.util.SPUtils;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * @author CYH06
 * 注册界面
 */
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.register_et_account)
    EditText registerEtAccount;
    @BindView(R.id.register_et_password)
    EditText registerEtPassword;
    @BindView(R.id.register_et_confirm_password)
    EditText registerEtConfirmPassword;
    @BindView(R.id.register_et_phone)
    EditText registerEtPhone;
    @BindView(R.id.register_gender)
    EditText registerGender;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.register_back)
    ImageView registerBack;
    private String[] sexArry = new String[]{"女", "男", "保密"};// 性别选择
    private int genderIndex;

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void init(Bundle bundle) {

    }

    @Override
    protected void initView() {
        genderIndex = SPUtils.getInstance(getBaseContext()).getInt("checkGender");
        TextChange textChange = new TextChange();
        registerEtPhone.addTextChangedListener(textChange);
        registerEtConfirmPassword.addTextChangedListener(textChange);
        registerEtAccount.addTextChangedListener(textChange);
        registerEtPassword.addTextChangedListener(textChange);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void destroy() {

    }


    @OnClick({R.id.register_back, R.id.register_gender, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_back:
                finish();
                break;
            case R.id.register_gender:
                showSexChooseDialog();
                break;
            case R.id.tv_register:
                String username = registerEtAccount.getText().toString().trim();
                String pwd = registerEtPassword.getText().toString().trim();
                String cpwd = registerEtConfirmPassword.getText().toString().trim();
                String tel = registerEtPhone.getText().toString().trim();
                if (!pwd.equals(cpwd)) {
                    showToast("两次密码不一致 ，请重新输入");
                    return;
                }
                getDataFormNet(username, pwd, cpwd, tel);
                break;
            default:
                break;
        }
    }


    private void getDataFormNet(String username, String password, String confirmPassword, String tel) {
        OkHttpUtils
                .post()
                .addParams("username", username)
                .addParams("password", password)
                .addParams("confirm_password", confirmPassword)
                .addParams("telephone", tel)
                .url(Api.REGISTER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showToast("注册失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        showToast("注册成功");
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
//                        ProcessData(response);
                    }

                });
    }

    /**
     * 性别选择框
     */
    private void showSexChooseDialog() {
        AlertDialog.Builder checkGender = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.checkGenderAlertDialog));// 自定义对话框
        // 2默认的选中
        checkGender.setSingleChoiceItems(sexArry, genderIndex, (dialog, which) -> {// which是被选中的位置
            // showToast(which+"");
            genderIndex = which;
            SPUtils.getInstance(this).put("checkGender", which);
            registerGender.setText(sexArry[which]);
            dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
        });
        checkGender.show();// 让弹出框显示
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
            boolean sign2 = registerEtAccount.getText().length() > 0;
            boolean sign = registerEtPassword.getText().length() > 0;
            boolean sign3 = registerEtConfirmPassword.getText().length() > 0;
            boolean sign4 = registerEtPhone.getText().length() > 0;
            if (sign2 & sign & sign3 & sign4) {
                tvRegister.setEnabled(true);
                tvRegister.setTextColor(Color.parseColor("#000000"));
            }
            // 在layout文件中，对Button的text属性应预先设置默认值，否则刚打开程序的时候Button是无显示的
            else {
                tvRegister.setEnabled(false);
                tvRegister.setTextColor(Color.parseColor("#66FFFFFF"));
            }
        }

    }
}
