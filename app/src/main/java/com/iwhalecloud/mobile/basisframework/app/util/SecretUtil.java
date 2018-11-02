package com.iwhalecloud.mobile.basisframework.app.util;

/**
 * AES-128加解密算法的Native代码实现（未完成）
 * @author MissArisha
 */
public class SecretUtil {

    static {
        System.loadLibrary("native-lib");
    }

    public static native String encrypt(String input, String key);

    public static native String decrypt(String input, String key);

}
