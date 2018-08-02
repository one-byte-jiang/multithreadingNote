package com.example.concurrencyday1.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample2 {
    //修饰一个类
    public static void test(){
        synchronized(SynchronizedExample2.class){
            for (int i = 0; i < 10 ; i++) {
                System.out.println("test - >" + i);
            }
        }
    }
    //修饰一个静态方法
    public synchronized static void test1(){
        for (int i = 0; i < 10 ; i++) {
            System.out.println("test1 - >" + i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(()->{
                synchronizedExample1.test();
            });
        executorService.execute(()->{
            synchronizedExample1.test();
        });
    }
}
