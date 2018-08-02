package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.ThreadSafe;

/**
 * 饿汉式 单例的示例在类装载的时候创建
 * */
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2(){
        //私有化构造器
    }
    private static SingletonExample2 singletonExample2 = new SingletonExample2();
    public static SingletonExample2 getSingletonExample2(){
        return singletonExample2;
    }
}
