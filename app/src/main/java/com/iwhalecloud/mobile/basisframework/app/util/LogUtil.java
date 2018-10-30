package com.iwhalecloud.mobile.basisframework.app.util;

import android.util.Log;

import com.iwhalecloud.mobile.basisframework.app.FrameworkApplication;

/**
 * 日志工具类
 * @author MissArisha
 */
public class LogUtil {

    private static final String DEFAULT_TAG = FrameworkApplication.getInstance().getPackageName();

    private static LogUtil instance;

    public synchronized static LogUtil getInstance() {
        if (instance == null) {
            instance = new LogUtil();
        }
        return instance;
    }

    public void v(String msg) {
        if(FrameworkApplication.DEBUG) {
            v(DEFAULT_TAG, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void v(String tag, String msg) {
        if(FrameworkApplication.DEBUG) {
            Log.v(tag, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void i(String msg) {
        if(FrameworkApplication.DEBUG) {
            i(DEFAULT_TAG, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void i(String tag, String msg) {
        if(FrameworkApplication.DEBUG) {
            Log.i(tag, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void d(String msg) {
        if(FrameworkApplication.DEBUG) {
            d(DEFAULT_TAG, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void d(String tag, String msg) {
        if(FrameworkApplication.DEBUG) {
            Log.d(tag, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void w(String msg) {
        if(FrameworkApplication.DEBUG) {
            w(DEFAULT_TAG, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void w(String tag, String msg) {
        if(FrameworkApplication.DEBUG) {
            Log.w(tag, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void e(String msg) {
        if(FrameworkApplication.DEBUG) {
            e(DEFAULT_TAG, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    public void e(String tag, String msg) {
        if(FrameworkApplication.DEBUG) {
            Log.e(tag, generateLogcatText(Thread.currentThread().getStackTrace(), msg, msg));
        }
    }

    private static String generateLogcatText(StackTraceElement[] traceElements, String msg, String message) {
        try {
            StringBuilder taskName = new StringBuilder();
            if (traceElements != null && traceElements.length > 4) {
                StackTraceElement traceElement = traceElements[4];
                taskName.append("(").append(traceElement.getFileName()).append(":").append(traceElement.getLineNumber()).append(") -> ");
                taskName.append(traceElement.getMethodName()).append("() : ").append(message);
            }
            return taskName.toString();
        } catch (Throwable throwable) {
            return msg;
        }
    }

}
