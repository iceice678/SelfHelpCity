package com.example.selfhelpcity.base;

/**
 * 接口地址
 */
public class Api {

    public static final long CONSTANT_BALANCE = 1000000000000000000L;

    public static final int PAGE_SIZE = 20;
    public static final String BASE_URL = "http://49.232.155.148/";
    //退出登录
    public static final String LOGOUT = BASE_URL + "logout";
    //获得室友列表
    public static final String GET_PEOPLE_LIST =BASE_URL+ "getShiyou";
    //获得房源列表
    public static final String GET_COMMUNITY_LIST = BASE_URL + "getFangYuanList";
    //注册
    public static final String REGISTER = BASE_URL + "register2";
    //登录
    public static final String LOGIN = BASE_URL + "login2";


}
