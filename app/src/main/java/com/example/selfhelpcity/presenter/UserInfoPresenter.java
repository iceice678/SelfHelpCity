package com.example.selfhelpcity.presenter;

import android.util.Log;

import com.comenjoysoft.baselibrary.presenter.BasePresenter;
import com.example.selfhelpcity.base.Api;
import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.bean.userInfo;
import com.example.selfhelpcity.model.biz.IUserInfoBiz;
import com.example.selfhelpcity.model.impl.UserInfoImpl;
import com.example.selfhelpcity.model.iview.IUserInfoView;
import com.example.selfhelpcity.model.listener.CallbackListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

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

    public void setUserInfo(String username, String personal, String age, String sex, String phone) {
        OkHttpUtils
                .get()
                .addParams("user_id", String.valueOf(Constant.USER_ID))
                .addParams("username", username)
                .addParams("sex", personal)
                .addParams("age", age)
                .addParams("telephone", sex)
                .addParams("gxqm", phone)
                .url(Api.MODIFY_INFO)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showToast("修改失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mView.showToast("修改成功");
                        getUserInfo();
                    }
                });
    }
//    public void setUserInfo(String username, String personal, String age, String sex, String phone) {
//        biz.setUserInfo(username, personal, age, sex, phone, new CallbackListener<userInfo>() {
//            @Override
//            public void success(userInfo object) {
//                mView.updateInfo(object.getData());
//            }
//
//            @Override
//            public void failed(Object object) {
//                mView.showToast("加载失败");
//            }
//        });
//    }
}
