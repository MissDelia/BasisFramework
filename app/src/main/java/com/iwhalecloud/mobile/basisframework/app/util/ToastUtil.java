package com.iwhalecloud.mobile.basisframework.app.util;

import android.widget.Toast;

/**
 * Toast轻消息工具（未完成）
 * @author MissArisha
 */
public class ToastUtil {

    private static Toast mToast;

    private static ToastUtil instance;

    public synchronized static ToastUtil getInstance() {
        if (instance == null) {
            instance = new ToastUtil();
        }
        return instance;
    }

}
