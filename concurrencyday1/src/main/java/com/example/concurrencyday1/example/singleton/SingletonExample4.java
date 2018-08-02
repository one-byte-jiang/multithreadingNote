package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.NotThreadSafe;
import com.example.concurrencyday1.annoation.ThreadSafe;

/**
 * 懒汉式 单例的示例在第一次使用时创建
 * 双重同步锁。   但是它居然不是一个线程安全的！
 * */
@ThreadSafe
public class SingletonExample4 {
    private SingletonExample4(){
        //私有化构造器
    }
    private static volatile SingletonExample4 singletonExample1 = null;
    public static  SingletonExample4 getSingletonExample1(){
        if(singletonExample1==null){
            synchronized (SingletonExample4.class){
                if(singletonExample1==null){
                    singletonExample1=new SingletonExample4();
                    //singletonExample1=new SingletonExample4();执行步骤是什么？
                    //1.memory=allocate() 分配对象内存空间
                    //2.ctorInstance()   初始化对象
                    //3.singletonExample1 =  memory 指向刚分配的内存
                    /*指令重排对单线程是没有影响的，但是对于多线程是有影响的*/

                    //JVM和CPU优化，发生了指令重排
                    //1.memory=allocate() 分配对象内存空间
                    //3.singletonExample1 =  memory 指向刚分配的内存
                    //2.ctorInstance()   初始化对象

                    //如何避免指令重排呢？使用关键字volatile

                }
            }
        }
        return singletonExample1;
    }
}
