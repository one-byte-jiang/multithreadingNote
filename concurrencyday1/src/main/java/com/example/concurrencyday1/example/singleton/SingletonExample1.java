package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.NotThreadSafe;

/**
 * 懒汉式 单例的示例在第一次使用时创建
 * */
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1(){
        //私有化构造器
    }
    private static SingletonExample1 singletonExample1 = null;
    public static SingletonExample1 getSingletonExample1(){
        if(singletonExample1==null)
            singletonExample1=new SingletonExample1();
        return singletonExample1;
    }
}
