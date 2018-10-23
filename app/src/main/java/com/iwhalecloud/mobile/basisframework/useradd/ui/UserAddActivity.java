package com.iwhalecloud.mobile.basisframework.useradd.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.iwhalecloud.mobile.basisframework.app.base.BaseActivity;
import com.iwhalecloud.mobile.basisframework.useradd.viewmodel.UserAddViewModel;

public class UserAddActivity extends BaseActivity<UserAddViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Class<UserAddViewModel> getViewModelClass() {
        return UserAddViewModel.class;
    }
}
