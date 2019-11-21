package com.example.selfhelpcity.presenter;

import com.comenjoysoft.baselibrary.presenter.BasePresenter;
import com.example.selfhelpcity.bean.userInfo;
import com.example.selfhelpcity.model.biz.IUserInfoBiz;
import com.example.selfhelpcity.model.impl.UserInfoImpl;
import com.example.selfhelpcity.model.iview.IUserInfoView;
import com.example.selfhelpcity.model.listener.CallbackListener;

public class UserInfoPresenter extends BasePresenter<IUserInfoView> {
    private IUserInfoBiz biz;

    public UserInfoPresenter(IUserInfoView view) {
        attachView(view);
        biz = new UserInfoImpl();
    }

    public void getUserInfo() {
        biz.getUserInfo(new CallbackListener<userInfo>() {
            @Override
            public void success(userInfo object) {
                mView.updateInfo(object.getData());
            }

            @Override
            public void failed(Object object) {
                mView.showToast("加载失败");
            }
        });
    }
}
