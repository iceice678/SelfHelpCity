package com.comenjoysoft.baselibrary.presenter;

import android.content.Context;

import com.comenjoysoft.baselibrary.model.iview.IBaseView;

/**
 * Author ： DemonJang
 * Data ： 2016/12/15
 * Dec ：BasePresenter
 */
public interface IPresenter<T extends IBaseView> {
//    void destroy();

    void attachView(Context context, T view);

    void attachView(T view);

    void detachView();
}