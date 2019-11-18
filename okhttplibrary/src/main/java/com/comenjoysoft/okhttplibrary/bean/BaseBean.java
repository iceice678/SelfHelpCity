package com.comenjoysoft.okhttplibrary.bean;

import java.io.Serializable;

/**
 * 服务器接口请求返回模型基类
 * {
 * "code":0
 * "msg":"OK"
 * }
 */
public class BaseBean implements Serializable {
    private String code;
    private String msg;

    public BaseBean() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}