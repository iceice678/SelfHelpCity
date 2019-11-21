package com.example.selfhelpcity.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.comenjoysoft.baselibrary.presenter.BasePresenter;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.bean.MyRelease;
import com.example.selfhelpcity.bean.ReleaseInfo;
import com.example.selfhelpcity.model.biz.IReleaseBiz;
import com.example.selfhelpcity.model.impl.ReleaseImpl;
import com.example.selfhelpcity.model.iview.IReleaseView;
import com.example.selfhelpcity.model.listener.CallbackListener;
import com.example.selfhelpcity.view.ReleaseInfoActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import comenjoy.com.imageloadlibrary.GlideUtil;
import okhttp3.Call;

public class ReleasePresenter extends BasePresenter<IReleaseView> {

    private IReleaseBiz biz;

    public ReleasePresenter(IReleaseView view) {
        attachView(view);
        biz = new ReleaseImpl();
    }

    public void getInfo() {
        biz.getReleaseInfo(new CallbackListener<MyRelease>() {
            @Override
            public void success(MyRelease object) {
                mView.updateInfo(object.getData());
            }

            @Override
            public void failed(Object object) {
                mView.showToast("加载失败");
            }
        });
    }


}
