package com.example.selfhelpcity.model.biz;

import com.example.selfhelpcity.bean.userInfo;
import com.example.selfhelpcity.model.listener.CallbackListener;

public interface IUserInfoBiz {
    void getUserInfo(final CallbackListener<userInfo> listener);
//    void setUserInfo(String username, String personal, String age, String sex, String phone, final CallbackListener<userInfo> listener);
}
