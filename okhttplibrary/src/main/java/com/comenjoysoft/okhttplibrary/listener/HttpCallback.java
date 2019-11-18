package com.comenjoysoft.okhttplibrary.listener;

/**
 * twp
 *
 * @param <T>
 */

public interface HttpCallback<T> {

    void onSuccess(T object);

    void onFailed(Object object);
}
