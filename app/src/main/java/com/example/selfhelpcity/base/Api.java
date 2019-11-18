package com.example.selfhelpcity.base;

/**
 * 接口地址
 */
public class Api {

    public static final long CONSTANT_BALANCE = 1000000000000000000L;

    public static final int PAGE_SIZE = 20;
    public static final String BASE_URL = Constant.IS_DEBUG ? "http://127.0.0.1:8080/ipns/" : "http://127.0.0.1:8080/ipns/";

    public static final String IPFS_URL = Constant.IS_DEBUG ? "http://127.0.0.1:5001/api/v0/" : "http://127.0.0.1:5001/api/v0/";

    public static final String BASE_URL_IMAGE = Constant.IS_DEBUG ? "http://127.0.0.1:8080/ipfs/" : "http://127.0.0.1:8080/ipfs/";

}
