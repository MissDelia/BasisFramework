package com.iwhalecloud.mobile.basisframework.app.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.iwhalecloud.mobile.basisframework.app.FrameworkApplication;

/**
 * SharedPreferences工具类
 * @author MissArisha
 */
public class SharedPreUtil {

    private static final String TAG = "";

    // 创建一个写入器
    private static SharedPreferences mPreferences;
    private static SharedPreUtil instance;

    public synchronized static SharedPreUtil getInstance() {
        if (instance == null) {
            instance = new SharedPreUtil();
        }
        return instance;
    }

    private SharedPreUtil() {
        mPreferences = FrameworkApplication.getInstance().getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    // 存入数据
    public void putString(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    // 获取数据
    public String getString(String key) {
        return getString(key, "");
    }

    // 获取数据
    public String getString(String key, String defValue) {
        return mPreferences.getString(key, defValue);
    }

    // 存入数据
    public void putInt(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    // 获取数据
    public int getInt(String key) {
        return getInt(key, 0);
    }

    // 获取数据
    public int getInt(String key, int defValue) {
        return mPreferences.getInt(key, defValue);
    }

    // 存入数据
    public void putFloat(String key, float value) {
        mPreferences.edit().putFloat(key, value).apply();
    }

    // 获取数据
    public float getFloat(String key) {
        return getFloat(key, 0.0f);
    }

    // 获取数据
    public float getFloat(String key, float defValue) {
        return mPreferences.getFloat(key, defValue);
    }

    // 移除数据
    public void removeKey(String key) {
        mPreferences.edit().remove(key).apply();
    }

}
