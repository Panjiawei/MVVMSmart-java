package com.wzq.sample.utils;


import com.wzq.sample.BuildConfig;

/**
 *
 * create by panjv On 2019-12-12
 */
public class GlobalUrl {

    // 1：dev，2：stg，3：product
    public static int ENV_TYPE = BuildConfig.ENV_TYPE;

    public static int ENV_INDEX = BuildConfig.ENV_TYPE - 1;

    public static String WECHAT_ID = "wx1f43561a224d8483";

    public static String[] SERVICE_URLS = new String[]{
            "http://app.dev.zhengdianpai.cn:9991/",
            "http://app.test.zhengdianpai.cn:9991/",
            "https://app.zhengdianpai.cn",
    };


    public static String[]  H5_HOSTS = new String[]{
            "https://patient-h5.zz-med-test.com",
            "https://patient-h5.zz-med-stg.com",
            "https://patient-h5.zz-med.com"
    };


    public static String[] APP_KEYS = new String[]{
            "5a2f7c4cb27b0a2e87000059",
            "5a2f7c4cb27b0a2e87000059",
            "5a2f7c4cb27b0a2e87000059"
    };

    public static String[] MESSAGE_SECRETS = new String[]{
            "55e220bf458399569128785c2cecadbc",
            "55e220bf458399569128785c2cecadbc",
            "55e220bf458399569128785c2cecadbc"
    };



    public static String[] WXAPPID = new String[]{
            "wx54f0c2cec6485644",
            "wx54f0c2cec6485644",
            WECHAT_ID
    };

    public static String[] WXAPPSECRET = new String[]{
            "d83263eb8d3b534a24d78949b2d59af8",
            "d83263eb8d3b534a24d78949b2d59af8",
            "3c56e9586eec7f0cb5c2821190761ca3"
    };




}
