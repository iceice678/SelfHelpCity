package com.example.selfhelpcity.model.biz;

import com.example.selfhelpcity.bean.Collection;
import com.example.selfhelpcity.model.listener.CallbackListener;

public interface ICollectionBiz {
    void getInfo(final CallbackListener<Collection> listener);
}
