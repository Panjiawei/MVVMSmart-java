package com.wzq.sample.utils.http;


import com.wzq.mvvmsmart.http.BaseResponse;
import com.wzq.sample.bean.DemoBean;
import com.wzq.sample.utils.http.service.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class HttpDataSourceImpl {
    private Api apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(Api apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl(Api apiService) {
        this.apiService = apiService;
    }


    public Observable<Object> login() {
        // TODO: wzq 2019/12/18  延迟时间
        return Observable.just(new Object()).delay(1, TimeUnit.SECONDS); //延迟3秒
    }


    public Observable<DemoBean> loadMore() {
        return Observable.create(new ObservableOnSubscribe<DemoBean>() {
            @Override
            public void subscribe(ObservableEmitter<DemoBean> observableEmitter) throws Exception {
                DemoBean entity = new DemoBean();
                List<DemoBean.ItemsEntity> students = new ArrayList<>();
                //模拟一部分假数据
                for (int i = 0; i < 10; i++) {
                    DemoBean.ItemsEntity student = new DemoBean.ItemsEntity();
                    student.setId(-1);
                    student.setName("模拟条目");
                    students.add(student);
                }
                entity.setItems(students);
                observableEmitter.onNext(entity);
            }
        }).delay(2, TimeUnit.SECONDS); //延迟3秒
    }

    public Observable<BaseResponse<DemoBean>> demoGet(int pageNum) {
        return apiService.demoGet(pageNum);
    }

    public Observable<BaseResponse<DemoBean>> demoPost(String catalog) {
        return apiService.demoPost(catalog);
    }
}
