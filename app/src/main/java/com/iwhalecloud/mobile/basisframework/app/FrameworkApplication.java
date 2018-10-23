package com.iwhalecloud.mobile.basisframework.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.iwhalecloud.mobile.basisframework.app.db.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author MissArisha
 */
public class FrameworkApplication extends Application {

    private static FrameworkApplication mInstance;

    private AppDatabase db;

    private ExecutorService executorService;

    private Retrofit mRetrofit;

    public synchronized static FrameworkApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        ThreadFactory namedThreadFactory = Executors.defaultThreadFactory();
        executorService = new ThreadPoolExecutor(4, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(AppKey.getInstance().url.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 所有数据库操作都必须使用Application的数据库实例
     * @return Application中的AppDatabase实例
     */
    public AppDatabase getAppDatabase() {
        return db;
    }

    /**
     * 所有的子线程都需要从Application的线程池中新建，不允许自建子线程
     * @return Application中的ExecutorService实例
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
