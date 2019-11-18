package com.example.selfhelpcity.base;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.selfhelpcity.BuildConfig;
import com.example.selfhelpcity.model.ObjectBox;

import java.io.File;

import io.objectbox.android.AndroidObjectBrowser;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

import static com.example.selfhelpcity.base.Constant.PATH_IPFS_DOWNLOAD;
import static com.example.selfhelpcity.base.Constant.PATH_IPFS_USB;

public class MyApplication extends Application {

    String TAG = "MyApp";
    public static boolean NETWORK_IS_AVAILABLE = true;

    public MyApplication() {
    }

    private static Context instance;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
        initAutoSize();
        initObjectBox();
        initFolder();
    }





    private void initFolder() {
        File ipfsPath = new File(PATH_IPFS_DOWNLOAD);
        if (!ipfsPath.exists()) {
            ipfsPath.mkdirs();
        }

        File usbPath = new File(PATH_IPFS_USB);
        if (!usbPath.exists()) {
            usbPath.mkdirs();
        }
    }


    public static void init(Application application) {
        if (instance == null) {
            instance = application.getApplicationContext();
        }
    }

    public void initObjectBox() {
        ObjectBox.init(this);
        if (BuildConfig.DEBUG) {
            boolean started = new AndroidObjectBrowser(ObjectBox.get()).start(this);
            Log.i("ObjectBrowser","ObjectBrowser Started: " + started);
        }
    }

    public void initAutoSize() {
        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(true)
                .setSupportSP(true)
                .setSupportSubunits(Subunits.NONE);
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}