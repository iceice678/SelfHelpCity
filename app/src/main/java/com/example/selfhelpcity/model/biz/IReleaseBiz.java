package com.example.selfhelpcity.model.biz;

import com.example.selfhelpcity.bean.MyRelease;
import com.example.selfhelpcity.model.listener.CallbackListener;

public interface IReleaseBiz {
    void getReleaseInfo( final CallbackListener<MyRelease> listener);

    void addReleaseInfo();
}
