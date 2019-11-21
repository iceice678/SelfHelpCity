package com.example.selfhelpcity.model.iview;

import com.comenjoysoft.baselibrary.model.iview.IBaseView;
import com.example.selfhelpcity.bean.Collection;

import java.util.List;

public interface ICollectionView extends IBaseView {
    void updateInfo(List<Collection.DataBean> data);
}
