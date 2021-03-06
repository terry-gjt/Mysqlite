package com.terrygjt.mysqlite;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.lang.Runnable;
/**
 * Created by terry on 2019-05-25.
 * ThreadPoolExecutor 参数介绍
 * corePoolSize    int 核心线程池大小
 * maximumPoolSize int 最大线程池大小
 * keepAliveTime   long 线程最大空闲时间
 * unit            TimeUnit 时间单位
 * workQueue       BlockingQueue<Runnable> 线程等待队列
 * threadFactory   ThreadFactory 线程创建工厂
 * handler         RejectedExecutionHandler 拒绝策略
 */

public class A {
    int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    int KEEP_ALIVE_TIME = 1;
    TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
    ExecutorService executorService = new ThreadPoolExecutor(NUMBER_OF_CORES,NUMBER_OF_CORES*2, KEEP_ALIVE_TIME,
//            KEEP_ALIVE_TIME_UNIT, taskQueue,new BackgroundThreadFactory(), new DefaultRejectedExecutionHandler());
                KEEP_ALIVE_TIME_UNIT, taskQueue,null, null);
//执行任务

    public A(java.lang.Runnable r) {
        executorService.execute(r);
    }
}
