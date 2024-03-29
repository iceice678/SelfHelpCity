package com.example.selfhelpcity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.adapter.MyReleaseAdapter;
import com.example.selfhelpcity.adapter.ReleaseAdapter;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.bean.MyRelease;
import com.example.selfhelpcity.model.iview.IReleaseView;
import com.example.selfhelpcity.presenter.ReleasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的发布界面
 */
public class ReleaseActivity extends BaseActivity implements IReleaseView {
    @BindView(R.id.release_back)
    ImageView releaseBack;
    @BindView(R.id.release_title)
    TextView releaseTitle;
    @BindView(R.id.release_rv)
    RecyclerView releaseRv;
    private MyReleaseAdapter releaseAdapter;
    private ReleasePresenter releasePresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_release;
    }

    @Override
    protected void init(Bundle bundle) {
        releasePresenter = new ReleasePresenter(this);
    }

    @Override
    protected void initView() {
        releaseAdapter = new MyReleaseAdapter();
        releaseRv.setLayoutManager(new LinearLayoutManager(ReleaseActivity.this));
        releaseRv.setAdapter(releaseAdapter);
    }

    @Override
    protected void initData() {
        releasePresenter.getInfo();
    }

    @Override
    protected void destroy() {

    }

    @OnClick({R.id.release_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.release_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void updateInfo(List<MyRelease.DataBean> data) {
        if (data != null) {
            releaseAdapter.setNewData(data);
        }
    }
}
