package com.example.selfhelpcity.model.iview;

import com.comenjoysoft.baselibrary.model.iview.IBaseView;
import com.example.selfhelpcity.bean.MyRelease;

import java.util.List;

public interface IReleaseView extends IBaseView {
    void updateInfo(List<MyRelease.DataBean> data);
}
