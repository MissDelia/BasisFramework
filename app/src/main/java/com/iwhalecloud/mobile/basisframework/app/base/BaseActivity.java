package com.iwhalecloud.mobile.basisframework.app.base;

import android.arch.lifecycle.ViewModelProviders;
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
        mViewModel = ViewModelProviders.of(this)
                .get(getViewModelClass());
    }

    protected T getViewModel() {
        return mViewModel;
    }

    /**
     * 子类实现此方法，获取到BaseViewModel的直接子类的Class<T>
     * @return
     */
    protected abstract Class<T> getViewModelClass();
}
