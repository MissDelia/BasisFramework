package com.iwhalecloud.mobile.basisframework.useradd.viewmodel;

import com.iwhalecloud.mobile.basisframework.app.FrameworkApplication;
import com.iwhalecloud.mobile.basisframework.app.base.BaseViewModel;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;

/**
 * @author MissArisha
 */
public class UserAddViewModel extends BaseViewModel {

    public void insertUser(final User user) {
        FrameworkApplication.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                FrameworkApplication.getInstance().getAppDatabase().userDao().insertAll(user);
            }
        });
    }
}
