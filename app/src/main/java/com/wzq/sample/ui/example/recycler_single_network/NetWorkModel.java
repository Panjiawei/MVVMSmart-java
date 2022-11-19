package com.wzq.sample.ui.example.recycler_single_network;

import com.wzq.mvvmsmart.base.BaseModelMVVM;
import com.wzq.sample.utils.http.service.Api;
import com.wzq.sample.utils.RetrofitClient;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * <p>作者：王志强<p>
 * <p>创建时间：2020/4/13<p>
 * <p>文件描述：<p>
 */
public class NetWorkModel extends BaseModelMVVM {


    Observable demoGet(int pageNum) {
        RetrofitClient instance = RetrofitClient.getInstance();
        Api api = instance.create(Api.class);
        return api.demoGet(pageNum);
    }


    public Completable loadMore() {
        return null;
    }
}
