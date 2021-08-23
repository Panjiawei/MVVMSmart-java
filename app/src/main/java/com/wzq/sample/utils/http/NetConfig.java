package com.wzq.sample.utils.http;

/**
 * Created by liheng on 2018/6/7 14:28
 */

public interface NetConfig {

    //=============================   考拉错误码校验  ==========================================

    /**
     * 请求成功
     */
    int REQUEST_SUCCESS = 0;

    /**
     * 身份令牌已过期，请重新登录
     */
    int USER_LOGIN_EXPIRED = 15000230;

    /**
     * 更新升级错误码
     */
    int UPDATE_NOW = 15000802;

    //=============================   考拉错误码校验  ==========================================

    /**
     * 连接错误,网络异常
     */
    int CONNECT_ERROR = 1001;
    /**
     * 连接超时
     */
    int CONNECT_TIMEOUT = 1002;

    /**
     * 解析错误
     */
    int PARSE_ERROR = 1003;
    /**
     * 未知错误
     */
    int UNKNOWN_ERROR = 1004;

    /**
     * 请求超时
     */
    int REQUEST_TIMEOUT = 1005;

    /**
     * 业务失败对应的状态码
     */
    int SERVER_ERROR = 1511500;

}
