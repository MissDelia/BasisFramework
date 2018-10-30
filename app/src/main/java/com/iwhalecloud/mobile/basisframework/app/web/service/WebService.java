package com.iwhalecloud.mobile.basisframework.app.web.service;

import com.iwhalecloud.mobile.basisframework.app.db.bean.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author MissArisha
 */
public interface WebService {

    /**
     * 获取UserInfo
     * @return Observable
     */
    @GET(value = "getUserInfo")
    Observable<List<User>> getUserInfo();

}
