package com.iwhalecloud.mobile.basisframework.app;

/**
 * @author MissArisha
 */
public class AppKey {

    private static AppKey mInstance;

    UrlBean url;

    public static synchronized AppKey getInstance() {
        if (mInstance == null) {
            mInstance = new AppKey();
        }
        return mInstance;
    }

    private AppKey() {
        url = new UrlBean();
    }

    class UrlBean {
        String baseUrl = "http://192.168.199.134:8080/Main/";
    }
}
