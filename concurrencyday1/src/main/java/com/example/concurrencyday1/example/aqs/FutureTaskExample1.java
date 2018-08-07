package com.example.concurrencyday1.example.aqs;

import java.util.concurrent.*;

public class FutureTaskExample1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.printf("正在执行任务...");
                Thread.sleep(2000);
                return "OK";
            }
        });
        new Thread(futureTask).start();
        Thread.sleep(1000);
        System.out.println(futureTask.get());
    }
}
