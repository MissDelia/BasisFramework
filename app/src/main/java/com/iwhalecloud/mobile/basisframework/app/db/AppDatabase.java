package com.iwhalecloud.mobile.basisframework.app.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.app.db.dao.UserDao;

/**
 * @author MissArisha
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    /**
     * 获取user表的DAO
     * @return UserDao
     */
    public abstract UserDao userDao();
}
