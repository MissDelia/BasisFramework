package com.iwhalecloud.mobile.basisframework.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.iwhalecloud.mobile.basisframework.app.db.bean.User;

import java.util.List;

/**
 * @author MissArisha
 */
@Dao
public interface UserDao extends BaseDao {

    /**
     * 根据ID获取User
     * @param userIds 用户ID
     * @return 返回列表的LiveData
     */
    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);

    /**
     * 获取User表所有数据返回List
     * @return 返回用户信息列表的LiveData
     */
    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAll();

    /**
     * 插入数据
     * @param users 不定个数的用户信息
     */
    @Insert
    void insertAll(User... users);

    /**
     * 插入数据
     * @param users 用户信息列表
     */
    @Insert
    void insertAll(List<User> users);

    /**
     * 删除数据
     * @param user 用户信息
     */
    @Delete
    void delete(User user);

}
