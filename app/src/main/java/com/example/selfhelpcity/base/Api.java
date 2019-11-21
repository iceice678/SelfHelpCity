package com.example.selfhelpcity.base;

/**
 * 接口地址
 */
public class Api {

    public static final long CONSTANT_BALANCE = 1000000000000000000L;

    public static final int PAGE_SIZE = 20;
    public static final String BASE_URL = "http://49.232.155.148/";

    public static final String Imgge = BASE_URL + "/images/";
    /**
     * 退出登录
     */
    public static final String LOGOUT = BASE_URL + "logout";
    /**
     * 获得室友列表
     */
    public static final String GET_PEOPLE_LIST = BASE_URL + "getShiyou";
    /**
     * 获得房源列表
     */
    public static final String GET_COMMUNITY_LIST = BASE_URL + "getFangYuanList";
    /**
     * 注册
     */
    public static final String REGISTER = BASE_URL + "register2";
    /**
     * 登录
     */
    public static final String LOGIN = BASE_URL + "login2";
    /**
     * 修改个人信息
     */
    public static final String MODIFY_INFO = BASE_URL + "updateUser2";
    /**
     * 修改密码
     */
    public static final String CHANGE_PASSWORD = BASE_URL + "updatePwd2";
    /**
     * 获取个人信息
     */
    public static final String GET_PERSONAL_INFORMATION = BASE_URL + "getMyInfo";
    /**
     * 获取房源详细信息
     */
    public static final String GET_LISTING_DETAILS = BASE_URL + "getFangyuanInfo";
    /**
     * 添加关注
     */
    public static final String ADD_ATTENTION = BASE_URL + "addFocus2";
    /**
     * 取消关注
     */
    public static final String UNSUBSCRIBE = BASE_URL + "deleteFocus";
    /**
     * 获得我的全部关注
     */
    public static final String GET_ALL_MY_ATTENTION = BASE_URL + "getMyAllFocus";
    /**
     * 添加留言
     */
    public static final String ADD_A_MESSAGE = BASE_URL + "addLiuyan";
    /**
     * 获取房源的留言
     */
    public static final String GET_A_MESSAGE_FOR_THE_LISTING = BASE_URL + "getLiuyan";
    /**
     * 获取我发布的房源
     */
    public static final String GET_MY_PUBLISHED_LISTINGS = BASE_URL + "getMyFabu";
    /**
     * 删除房源
     */
    public static final String DELETE_LISTING = BASE_URL + "deleteFangyuan";


}
