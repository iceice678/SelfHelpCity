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

public class AddReleaseActivity extends BaseActivity {
    @BindView(R.id.add_release_back)
    ImageView addReleaseBack;
    @BindView(R.id.add_release_img1)
    ImageView addReleaseImg1;
    @BindView(R.id.add_release_name)
    EditText addReleaseName;
    @BindView(R.id.add_release_address)
    EditText addReleaseAddress;
    @BindView(R.id.add_release_price)
    EditText addReleasePrice;
    @BindView(R.id.add_release_area)
    EditText addReleaseArea;
    @BindView(R.id.add_release_gender)
    EditText addReleaseGender;
    @BindView(R.id.add_release_standard)
    EditText addReleaseStandard;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    @Override
    protected int getContentView() {
        return R.layout.activity_add_release;
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


    @OnClick({R.id.add_release_back, R.id.add_release_img1, R.id.add_release_gender, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_release_back:
                finish();
                break;
            case R.id.add_release_img1:
                break;
            case R.id.add_release_gender:
                break;
            case R.id.tv_register:
                break;
            default:
                break;
        }
    }
}
