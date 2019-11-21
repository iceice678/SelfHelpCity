package com.example.selfhelpcity.presenter;

import com.comenjoysoft.baselibrary.presenter.BasePresenter;
import com.example.selfhelpcity.bean.Collection;
import com.example.selfhelpcity.bean.MyRelease;
import com.example.selfhelpcity.model.biz.ICollectionBiz;
import com.example.selfhelpcity.model.biz.IReleaseBiz;
import com.example.selfhelpcity.model.impl.CollectionImpl;
import com.example.selfhelpcity.model.impl.ReleaseImpl;
import com.example.selfhelpcity.model.iview.ICollectionView;
import com.example.selfhelpcity.model.iview.IReleaseView;
import com.example.selfhelpcity.model.listener.CallbackListener;

public class CollectionPresenter extends BasePresenter<ICollectionView> {

    private ICollectionBiz biz;

    public CollectionPresenter(ICollectionView view) {
        attachView(view);
        biz = new CollectionImpl();
    }

    public void getInfo() {
        biz.getInfo(new CallbackListener<Collection>() {
            @Override
            public void success(Collection object) {
                mView.updateInfo(object.getData());
            }

            @Override
            public void failed(Object object) {
                mView.showToast("获取收藏房源失败");
            }
        });


    }
}
