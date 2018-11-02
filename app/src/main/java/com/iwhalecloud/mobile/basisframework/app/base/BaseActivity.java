package com.iwhalecloud.mobile.basisframework.app.base;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.iwhalecloud.mobile.basisframework.app.util.StatusBarUtil;

/**
 * @author MissArisha
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    private T mViewModel;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 沉浸式状态栏，视情况加入
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
        StatusBarUtil.getInstance().StatusBarLightMode(this);

        if (getViewModelClass() != null) {
            mViewModel = ViewModelProviders.of(this)
                    .get(getViewModelClass());
        }
    }

    protected T getViewModel() {
        return mViewModel;
    }

    /**
     * 子类实现此方法，获取到BaseViewModel的直接子类的Class<T>
     * @return 返回Class<T>
     */
    protected abstract Class<T> getViewModelClass();

    /**
     * 界面跳转方法（Stable）
     * @param clz Activity的Class
     * @param bundle 参数
     */
    public void goActivity(Class<?> clz, Bundle bundle) {
        // 如果是Activity才进行跳转
        if (BaseActivity.class.isAssignableFrom(clz)) {
            Intent intent = new Intent(this, clz);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
        }
    }

    /**
     * 界面跳转方法（Stable）
     * @param clz Activity的Class
     */
    public void goActivity(Class<?> clz) {
        goActivity(clz, null);
    }
}
