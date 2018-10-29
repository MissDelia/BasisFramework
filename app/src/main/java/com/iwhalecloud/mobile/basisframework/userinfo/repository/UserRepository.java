package com.iwhalecloud.mobile.basisframework.userinfo.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.iwhalecloud.mobile.basisframework.app.FrameworkApplication;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.app.web.service.WebService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author MissArisha
 */
public class UserRepository {

    private static UserRepository mInstance;

    private WebService mWebService;

    public static UserRepository getInstance() {
        if (mInstance == null) {
            mInstance = new UserRepository();
        }
        return mInstance;
    }

    private UserRepository()  {
        mWebService = FrameworkApplication.getInstance().getRetrofit().create(WebService.class);
    }

    /**
     * 返回列表信息
     * 若网络获取失败则获取本地
     * @return
     */
    public LiveData<List<User>> getUsers() {
        final MediatorLiveData<List<User>> userData = new MediatorLiveData<>();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(mWebService.getUserInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        if (users != null && users.size() > 0) {
                            userData.setValue(users);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        userData.addSource(FrameworkApplication.getInstance().getAppDatabase().userDao().loadAll(), new Observer<List<User>>() {
                            @Override
                            public void onChanged(@Nullable List<User> users) {
                                userData.setValue(users);
                            }
                        });
                    }
                }));

        return userData;
    }

}
