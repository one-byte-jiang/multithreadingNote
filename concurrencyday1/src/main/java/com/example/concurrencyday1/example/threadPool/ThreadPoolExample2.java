package com.example.concurrencyday1.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {//假设我们给线程池放置10个任务
            final  int index = i;//代表当前任务的序号
            executorService.execute(()->{
                System.out.println("task:"+index);
           });
        }
        executorService.shutdown();//一定要记住关闭线程池，防止浪费资源
    }
}
