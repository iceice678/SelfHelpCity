package com.example.selfhelpcity.util;

public interface ICallback {
    abstract  void callback(boolean reqSuccess, String statusCode, String data);
}
