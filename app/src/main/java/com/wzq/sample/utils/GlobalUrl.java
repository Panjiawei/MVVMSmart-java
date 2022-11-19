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


    public static String[] SERVICE_URLS = new String[]{

    };







}
