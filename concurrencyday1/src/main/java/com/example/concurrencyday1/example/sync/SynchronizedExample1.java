package com.example.concurrencyday1.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample1 {
    public void test(){
        synchronized(this){//修饰代码块
            for (int i = 0; i < 10 ; i++) {
                System.out.println("test - >" + i);
            }
        }
    }
    //修饰一个方法
    public synchronized void test1(){
        for (int i = 0; i < 10 ; i++) {
            System.out.println("test1 - >" + i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(()->{
                synchronizedExample1.test();
            });
        executorService.execute(()->{
            synchronizedExample1.test();
        });
    }
}
