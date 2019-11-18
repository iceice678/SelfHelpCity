package com.example.selfhelpcity.model.listener;

/**
 * Author ： DemonJang
 * Data ： 2017/5/16
 * Dec ：description
 */

public interface CallbackListener<T> {

    void success(T object);

    void failed(Object object);
}
