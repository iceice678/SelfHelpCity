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
 * 我的收藏界面
 */
public class CollectionActivity extends BaseActivity {
    @BindView(R.id.collection_back)
    ImageView collectionBack;
    @BindView(R.id.collection_title)
    TextView collectionTitle;

    @Override
    protected int getContentView() {
        return R.layout.activity_collection;
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

    @OnClick({R.id.collection_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collection_back:
                finish();
                break;
            default:
                break;
        }
    }
}
