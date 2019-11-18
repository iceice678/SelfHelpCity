package com.example.selfhelpcity.model;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TheadPoolManager {

    private volatile static TheadPoolManager mSingleInstance = null;
    private ThreadPoolExecutor threadPool;

    private TheadPoolManager() {
        threadPool = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
    }

    public static TheadPoolManager getInstance() {
        if (mSingleInstance == null) {
            synchronized (TheadPoolManager.class) {
                if (mSingleInstance == null) {
                    mSingleInstance = new TheadPoolManager();
                }
            }
        }
        return mSingleInstance;
    }
}
