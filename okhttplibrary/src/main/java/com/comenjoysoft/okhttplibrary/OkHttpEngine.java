package com.comenjoysoft.okhttplibrary;

import android.os.Handler;
import android.os.Looper;

import com.comenjoysoft.okhttplibrary.listener.HttpCallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpEngine {

    //    private Retrofit.Builder retrofitBuilder;
    private final OkHttpClient client;
    private volatile static OkHttpEngine mSingleInstance = null;
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private Handler handler = new Handler(Looper.getMainLooper());

    private OkHttpEngine() {
//        retrofitBuilder = new Retrofit.Builder();
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .callTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
//        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());//增加RxJava2CallAdapterFactory
//        rxCacheBuilder = new RxCache.Builder().init(sContext)
//                .diskConverter(new SerializableDiskConverter());      //目前只支持Serializable和Gson缓存其它可以自己扩展
    }

    public static OkHttpEngine getInstance() {
        if (mSingleInstance == null) {
            synchronized (OkHttpEngine.class) {
                if (mSingleInstance == null) {
                    mSingleInstance = new OkHttpEngine();
                }
            }
        }
        return mSingleInstance;
    }

    private void handlerCallback(final Response response, final HttpCallback callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (response.body() != null) {
                    try {
                        callback.onSuccess(response.body().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    callback.onFailed(response);
                }
            }
        });
    }

    private void handlerFailureCallback(final IOException e, final HttpCallback callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onFailed(e);
            }
        });
    }

    /**
     * 封装同步的Get请求方式
     */
    public Call getSync(String urlStr, HttpCallback<String> callback) {
        Request request = new Request.Builder().url(urlStr).build();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            if (response.body() != null) {
                callback.onSuccess(response.body().string());
            } else {
                callback.onFailed(response);
            }
        } catch (IOException e) {
            callback.onFailed(e);
        }
        return call;
    }

    /**
     * 异步的get请求
     *
     * @param url
     * @param callback
     */
    public void getAsync(String url, final HttpCallback<String> callback) {
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) {
                if (response.body() != null) {
                    try {
                        final String body = response.body().string();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(body);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailed(response);
                        }
                    });
                }
            }
        });
    }

//    //同步的Post
//    public String postAync(String url, String json) {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder().url(url).post(body).build();
//        return okHttpClient.newCall(request).execute().body().string();
//    }
//
//    //异步的get和post
//    public void getAsync(String url, Callback callback) {
//        Request request = new Request.Builder().url(url).build();
//        okHttpClient.newCall(request).enqueue(callback);
//    }
//
//    public void postAsync(String url, Callback callback) {
//        RequestBody body = new FormBody.Builder().add("key", "value").build();
//        Request request = new Request.Builder().url(url).post(body).build();
//        okHttpClient.newCall(request).enqueue(callback);
//    }
}
