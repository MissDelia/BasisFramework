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

    public static final boolean DEBUG = true;

    private static FrameworkApplication mInstance;

    private AppDatabase db;
    /*
     * 项目中的线程池有且仅有一个
     * 如果并发量大于一下maximumPoolSize，应自己优化代码，不允许修改maximumPoolSize
     */
    private ExecutorService executorService;
    /*
     * 如果要多个基于不同IP的接口，必须在Application中创建多个Retrofit实例使用
     * 不允许在其它地方创建Retrofit实例，以免浪费内存
     */
    private Retrofit mRetrofit;
    // 线程池线程数为CPU核心数量
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    // 核心线程数量大小
    private static final int corePoolSize = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    /*
     * 如果是CPU密集型应用,则线程池大小设置为N+1
     * 如果是IO密集型应用,则线程池大小设置为2N+1
     */
    private static final int maximumPoolSize = CPU_COUNT * 2 + 1;
    // 线程空闲后的存活时长
    private static final int keepAliveTime = 30;

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
        executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
        // 可选择不设置超时
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
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

    public synchronized Retrofit getRetrofit() {
        /*
         * 防止过多Retrofit实例在onCreate中创建造成内存浪费，改为使用时创建
         */
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(AppKey.getInstance().url.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
