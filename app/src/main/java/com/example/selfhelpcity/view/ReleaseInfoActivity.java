package com.example.selfhelpcity.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ReleaseInfoActivity extends BaseActivity {
    @BindView(R.id.release_info_back)
    ImageView releaseInfoBack;
    @BindView(R.id.release_info_img)
    ImageView releaseInfoImg;
    @BindView(R.id.release_info_name)
    TextView releaseInfoName;
    @BindView(R.id.release_info_price)
    TextView releaseInfoPrice;
    @BindView(R.id.release_info_address)
    TextView releaseInfoAddress;
    @BindView(R.id.release_info_housetype)
    TextView releaseInfoHousetype;
    @BindView(R.id.release_info_area)
    TextView releaseInfoArea;
    @BindView(R.id.release_info_collection)
    AppCompatCheckBox releaseInfoCollection;
    @BindView(R.id.release_info_rv)
    RecyclerView releaseInfoRv;
    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.release_info_navigation)
    TextView releaseInfoNavigation;
    @BindView(R.id.release_info_evaluation)
    TextView releaseInfoEvaluation;
    @BindView(R.id.release_info_contact)
    TextView releaseInfoContact;

    @Override
    protected int getContentView() {
        return R.layout.activity_release_info;
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


    @OnClick({R.id.release_info_back, R.id.release_info_navigation, R.id.release_info_evaluation, R.id.release_info_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.release_info_back:
                finish();
                break;
            case R.id.release_info_navigation:
                showToast("正在开发");
                break;
            case R.id.release_info_evaluation:
                showToast("正在开发");
                break;
            case R.id.release_info_contact:
                startActivity(new Intent(ReleaseInfoActivity.this, ChatActivity.class).putExtra("targetId", "801139"));
                break;
        }
    }
}
