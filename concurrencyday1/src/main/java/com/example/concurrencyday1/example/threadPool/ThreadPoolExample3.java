package com.example.concurrencyday1.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample3 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
       /* executorService.schedule(()->{
            System.out.println("hello");
        },3,TimeUnit.SECONDS);//延迟3秒执行调度任务*/
        executorService.scheduleAtFixedRate(()->{
            System.out.println("hello");
        },1,3,TimeUnit.SECONDS);//每隔3秒执行一次
       // executorService.shutdown();//一定要记住关闭线程池，防止浪费资源
    }
}
