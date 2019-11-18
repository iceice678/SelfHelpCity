package com.example.selfhelpcity.services;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.util.AEvent;
import com.example.selfhelpcity.util.IEventListener;
import com.example.selfhelpcity.util.XHChatManagerListener;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.camera.StarCamera;

/**
 * Created by zhangjt on 2017/8/6.
 */

public class KeepLiveService extends Service implements IEventListener {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initSDK();
        return super.onStartCommand(intent, flags, startId);
    }

    private void initSDK() {
        Constant.init(this);
        initFree();
    }

    private boolean isLogin = false;

    //开放版SDK初始化
    private void initFree() {
        isLogin = XHClient.getInstance().getIsOnline();
        if (!isLogin) {
            addListener();

            XHCustomConfig customConfig = XHCustomConfig.getInstance(this);

            customConfig.setImServerUrl(Constant.IM_SERVER_URL);
//            customConfig.setLogEnable(false); //关闭SDK调试日志
//            customConfig.setDefConfigOpenGLESEnable(false);
//            customConfig.setDefConfigCameraId(1);//设置默认摄像头方向  0后置  1前置
//            customConfig.setDefConfigVideoSize(XHConstants.XHCropTypeEnum.STAR_VIDEO_CONFIG_360BW_640BH_180SW_320SH);
//            customConfig.setLogDirPath(Environment.getExternalStorageDirectory().getPath()+"/starrtcLog");
            customConfig.setDefConfigCamera2Enable(false);
            StarCamera.setFrameBufferEnable(false);
            customConfig.initSDKForFree(String.valueOf(Constant.userId), new IXHErrorCallback() {
                @Override
                public void error(final String errMsg, Object data) {
                    Log.d("  KeepLiveService", "error: " + errMsg);
                }
            }, new Handler());
            XHClient.getInstance().getChatManager().addListener(new XHChatManagerListener());
            XHClient.getInstance().getLoginManager().loginFree(new IXHResultCallback() {
                @Override
                public void success(Object data) {
                    Log.d("KeepLiveService", "loginSuccess");
                    isLogin = true;
                }

                @Override
                public void failed(final String errMsg) {
                    Log.d("KeepLiveService", "loginFailed " + errMsg);
                }
            });
        }
    }

    @Override
    public void dispatchEvent(String aEventID, boolean success, Object eventObj) {
        switch (aEventID) {
            case AEvent.AEVENT_C2C_REV_MSG:
            case AEvent.AEVENT_REV_SYSTEM_MSG:
                Constant.hasNewC2CMsg = true;
                break;
            case AEvent.AEVENT_LOGOUT:
                removeListener();
                this.stopSelf();
                break;
        }
    }

    private void addListener() {
        AEvent.addListener(AEvent.AEVENT_LOGOUT, this);
        AEvent.addListener(AEvent.AEVENT_C2C_REV_MSG, this);
        AEvent.addListener(AEvent.AEVENT_REV_SYSTEM_MSG, this);
    }

    private void removeListener() {
        AEvent.removeListener(AEvent.AEVENT_LOGOUT, this);
        AEvent.removeListener(AEvent.AEVENT_C2C_REV_MSG, this);
        AEvent.removeListener(AEvent.AEVENT_REV_SYSTEM_MSG, this);
    }

}
