package com.iwhalecloud.mobile.basisframework.app.util;

import android.view.Gravity;
import android.widget.Toast;

import com.iwhalecloud.mobile.basisframework.app.FrameworkApplication;
import com.iwhalecloud.mobile.basisframework.app.view.ToastTextView;

/**
 * Toast轻消息工具
 * @author MissArisha
 */
public class ToastUtil {

    private static Toast mToast;

    private static ToastUtil instance;

    private ToastTextView tv_content;

    public synchronized static ToastUtil getInstance() {
        if (instance == null) {
            instance = new ToastUtil();
        }
        if (mToast == null) {
            mToast = new Toast(FrameworkApplication.getInstance());
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        return instance;
    }

    public void setTime(int length) {
        if (mToast != null) {
            mToast.setDuration(length);
        }

    }

    public void showToast(String text) {
        showToast(text, Gravity.BOTTOM, 0, 0);
    }

    public void showToast(String text, int gravity) {
        showToast(text, gravity, 0, 0);
    }

    public void showToastCenter(String text) {
        showToast(text, Gravity.CENTER, 0, 0);
    }

    public void showToast(String text, int gravity, int xOffset, int yOffset) {
        setAttribute(text, gravity, xOffset, yOffset);
    }

    private void setAttribute(String text, int gravity, int xOffset, int yOffset) {
        if (this.tv_content == null) {
            this.tv_content = new ToastTextView(FrameworkApplication.getInstance());
        }

        this.tv_content.setText(text);
        mToast.setView(this.tv_content);
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }


}
