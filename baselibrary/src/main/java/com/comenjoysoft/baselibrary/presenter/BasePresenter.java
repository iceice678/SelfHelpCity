package com.comenjoysoft.baselibrary.presenter;

import android.content.Context;

import com.comenjoysoft.baselibrary.model.iview.IBaseView;

/**
 * Author ： twp
 * Data ： 2016/12/15
 * Dec ：BasePresenter
 */
public abstract class BasePresenter<T extends IBaseView> implements IPresenter<T> {

    Context mContext;
    public T mView;

    @Override
    public void attachView(Context context, T view) {
        mView = view;
        mContext = context;
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mContext = null;
        mView = null;
    }
}