package com.example.selfhelpcity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.adapter.CollectionAdapter;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.bean.Collection;
import com.example.selfhelpcity.model.iview.ICollectionView;
import com.example.selfhelpcity.presenter.CollectionPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的收藏界面
 */
public class CollectionActivity extends BaseActivity implements ICollectionView {
    @BindView(R.id.collection_back)
    ImageView collectionBack;
    @BindView(R.id.collection_title)
    TextView collectionTitle;
    @BindView(R.id.collection_rv)
    RecyclerView collectionRv;
    private CollectionAdapter collectionAdapter;
    private CollectionPresenter collectionPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_collection;
    }

    @Override
    protected void init(Bundle bundle) {
        collectionPresenter = new CollectionPresenter(this);
    }

    @Override
    protected void initView() {
        collectionAdapter = new CollectionAdapter();
        collectionRv.setLayoutManager(new LinearLayoutManager(CollectionActivity.this));
        collectionRv.setAdapter(collectionAdapter);
        collectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    protected void initData() {
        collectionPresenter.getInfo();
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

    @Override
    public void updateInfo(List<Collection.DataBean> data) {
        if (data != null) {
            collectionAdapter.setNewData(data);
        }
    }


}
