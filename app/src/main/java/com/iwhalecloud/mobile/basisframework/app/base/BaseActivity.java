package com.iwhalecloud.mobile.basisframework.app.base;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author MissArisha
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    private T mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if (clz.isAssignableFrom(BaseActivity.class)) {
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
