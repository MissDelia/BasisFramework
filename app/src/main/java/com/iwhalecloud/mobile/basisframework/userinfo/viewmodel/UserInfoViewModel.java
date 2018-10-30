package com.iwhalecloud.mobile.basisframework.userinfo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.iwhalecloud.mobile.basisframework.app.base.BaseViewModel;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.userinfo.repository.UserRepository;

import java.util.List;

/**
 * @author MissArisha
 */
public class UserInfoViewModel extends BaseViewModel {

    /**
     * 提供完整的用户信息
     */
    public LiveData<List<User>> getUsers() {
        return UserRepository.getInstance().getUsers();
    }

}
