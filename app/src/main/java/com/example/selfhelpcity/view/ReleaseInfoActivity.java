package com.example.selfhelpcity.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.bean.ReleaseInfo;
import com.example.selfhelpcity.util.ThreadUtils;
import com.flyco.DialogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import comenjoy.com.imageloadlibrary.GlideUtil;
import okhttp3.Call;

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
    private Dialog dialog;

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

    @Override
    protected void onResume() {
        super.onResume();
        int intent = getIntent().getIntExtra("commuityId", 0);
        if (intent > 0) {
            dialog = DialogUtil.getInstance(ReleaseInfoActivity.this).loadingDialog("加载中");
            getDataFormNet(intent);
        }
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
            default:
                break;
        }
    }


    private void getDataFormNet(int id) {
        OkHttpUtils
                .post()
                .addParams("fy_id", String.valueOf(id))
                .url(Api.GET_LISTING_DETAILS)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        dialog.dismiss();
                        showToast("数据加载失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("Releaseljy", response);
                        if (!response.isEmpty()) {
                            ReleaseInfo releaseInfo = JSON.parseObject(response, ReleaseInfo.class);
                            GlideUtil.getInstance().loadImage(ReleaseInfoActivity.this, Api.Imgge + releaseInfo.getData().getPicture(), R.mipmap.bsd, releaseInfoImg);
                            releaseInfoAddress.setText(releaseInfo.getData().getAddress());
                            releaseInfoPrice.setText(releaseInfo.getData().getZujin()+"");
                            releaseInfoArea.setText(releaseInfo.getData().getMianji() + "m");
                            releaseInfoHousetype.setText(releaseInfo.getData().getHuxing());
                            dialog.dismiss();
                        }
                    }

                });
    }
}
