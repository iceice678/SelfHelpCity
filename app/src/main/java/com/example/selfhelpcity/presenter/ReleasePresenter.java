package com.example.selfhelpcity.presenter;

import com.comenjoysoft.baselibrary.presenter.BasePresenter;
import com.example.selfhelpcity.model.biz.IReleaseBiz;
import com.example.selfhelpcity.model.impl.ReleaseImpl;
import com.example.selfhelpcity.model.iview.IReleaseView;

public class ReleasePresenter extends BasePresenter<IReleaseView> {

    private IReleaseBiz biz;

    public ReleasePresenter(IReleaseView view) {
        attachView(view);
        biz = new ReleaseImpl();
    }
    public void getInfo(){

    }
}
