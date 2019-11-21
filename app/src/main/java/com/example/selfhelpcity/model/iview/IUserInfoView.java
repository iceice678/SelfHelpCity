package com.example.selfhelpcity.model.iview;

import com.comenjoysoft.baselibrary.model.iview.IBaseView;
import com.example.selfhelpcity.bean.userInfo;

public interface IUserInfoView extends IBaseView {
    void updateInfo(userInfo.DataBean dataBean);
}
