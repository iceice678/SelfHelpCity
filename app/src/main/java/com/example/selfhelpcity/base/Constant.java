package com.example.selfhelpcity.base;


import android.content.Context;

import com.example.selfhelpcity.util.PathUtils;

public class Constant {
    //是否是本地调试版本
    public static final Boolean IS_DEBUG = true;

    // TODO 加密的key不能写在这里,现在只是临时写在这里
    /**
     * 对称加解密DES密钥Key
     */
    public final static String ENCRYPT_KEY = "deewipfs";
    public final static String ENCRYPT_IV = "ipfs";

    /* start SharedPreferences key */
    /*是否第一次启动*/
    public static final String SP_KEY_FIRST_LAUNCH = "isFirstLaunch";
    /**
     * 用户头像路径
     */
    public static final String SP_KEY_HEADPORTRAIT = "auHeadPortrait";
    /**
     * 钱包地址
     */
    public static final String SP_KEY_WALLET_ADDRESS = "walletAddress";
    /**
     * 钱包密码
     */
    public static final String SP_KEY_WALLET_PASSWORD = "walletPassword";
    /**
     * 钱包文件路径
     */
    public static final String SP_KEY_WALLET_PATH = "walletPath";

    public static final String SP_KEY_SERVER_PUBLIC_KEY = "serverPublicKey";
    public static final String SP_KEY_PRIVATE_KEY = "privateKey";
    public static final String SP_KEY_PUBLIC_KEY = "publicKey";

    /* end SharedPreferences key */

    public static final String PATH_IPFS_DOWNLOAD = PathUtils.getExternalStoragePath() + "/Ipfs/Download/";
    public static final String PATH_IPFS_USB = PathUtils.getExternalStoragePath() + "/Ipfs/USB/";

    public static Context appContext;
    public static String userId = "801138";

    public static String IM_SERVER_URL = "demo.starrtc.com:19903";

    public static boolean hasNewC2CMsg = false;

    public static String IM_GROUP_LIST_URL = "http://www.starrtc.com/aec/group/list.php";
    public static String IM_GROUP_INFO_URL = "http://www.starrtc.com/aec/group/members.php";

    public static final int LIST_TYPE_CHATROOM = 0;

    public static void init(Context context) {
        appContext = context.getApplicationContext();
//        userId = loadSharedData(context,"userId",userId);
//        IM_SERVER_URL = loadSharedData(context,"IM_SERVER_URL",IM_SERVER_URL);

    }

    /**
     * EventBus Action
     */
    public static final int ACTION_IPFS_SERVICE_OPENED = 1901;
}
