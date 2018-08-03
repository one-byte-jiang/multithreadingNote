package com.example.concurrencyday1.example.commonUnsafe;

import com.example.concurrencyday1.annoation.NotThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

@NotThreadSafe
public class ArrayListExample {
    public static int clientTotal = 50;//模拟用户的1000个请求
    public static int threadTotal = 50 ; //允许并发的线程数量
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();//定义一个线程池
        final Semaphore semaphore = new Semaphore(threadTotal);//信号量 允许并发的数目
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);//计数器
        for (int i = 0; i < clientTotal; i++) {
            //这里使用JDK1.8语法
            //使用线程池来创建请求
            executorService.execute(()->{
                try {
                    semaphore.acquire();//这里就会判断当前执行的并发量是否超过 上面定义的50 超过的话会在此阻塞
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();//每执行一次就会减一次
            });
        }
        countDownLatch.await();//当计数器里面的数字减为0后，程序将会往下执行
        executorService.shutdown();//关闭线程池
        System.out.println("list.size:"+list.size());
    }
    /*计数的方法*/
    public  static void add(){
        list.add(1);
    }
}
