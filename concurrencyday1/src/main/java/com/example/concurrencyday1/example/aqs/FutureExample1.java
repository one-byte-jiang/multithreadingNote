package com.example.concurrencyday1.example.aqs;

import java.util.concurrent.*;

public class FutureExample1 {
    static class MyCallable implements Callable<String>{//传入String,也就是说线程异步执行完毕返回的类型

        @Override
        public String call() throws Exception {
            System.out.printf("正在执行任务...");
            Thread.sleep(2000);
            return "OK";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> result = executorService.submit(new MyCallable());//让线程池直接提交这个任务
        System.out.printf("主线程继续执行下去");
        Thread.sleep(1000);
        System.out.printf( result.get());
    }
}
