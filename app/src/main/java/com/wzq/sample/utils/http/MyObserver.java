package com.wzq.sample.utils.http;

import android.util.Log;

import com.wzq.mvvmsmart.http.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author : panjiawei
 * date : 2021/8/20 10:53 上午
 * description :
 */
public abstract class MyObserver<T> implements Observer<BaseResponse<T>> {
    private static final String TAG = "MyObserver";

    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(BaseResponse<T> response) {
        //在这边对 基础数据 进行统一处理  举个例子：
        if (response.getCode() == NetConfig.REQUEST_SUCCESS) {
            onSuccess(response);
        } else {
            onFailure(null, response.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "Throwable: " + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
    }

    public abstract void onSuccess(BaseResponse<T> demo);

    public abstract void onFailure(Throwable e, String errorMsg);
}
