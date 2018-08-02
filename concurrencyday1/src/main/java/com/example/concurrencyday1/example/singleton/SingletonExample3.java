package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.NotRecommend;
import com.example.concurrencyday1.annoation.NotThreadSafe;
import com.example.concurrencyday1.annoation.ThreadSafe;

/**
 * 懒汉式 单例的示例在第一次使用时创建
 * */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    private SingletonExample3(){
        //私有化构造器
    }
    private static SingletonExample3 singletonExample1 = null;
    public static synchronized SingletonExample3 getSingletonExample1(){
        if(singletonExample1==null)
            singletonExample1=new SingletonExample3();
        return singletonExample1;
    }
}
