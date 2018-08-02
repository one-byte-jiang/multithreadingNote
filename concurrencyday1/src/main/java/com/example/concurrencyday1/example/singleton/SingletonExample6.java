package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.Recommend;
import com.example.concurrencyday1.annoation.ThreadSafe;

/**
 * 枚举模式
 * */
@ThreadSafe
@Recommend
public class SingletonExample6 {
    private SingletonExample6(){
        //私有化构造器
    }
    public static SingletonExample6 getSingletonExample6(){
       return Singleton.INSTANCE.getSingleton();
    }
   private enum  Singleton{
        INSTANCE;
        private SingletonExample6 singleton;
        //JVM保证这个方法绝对只调用一次
       Singleton(){
           singleton=new SingletonExample6();
       }
       public SingletonExample6 getSingleton(){
           return singleton;
       }
    }
}
