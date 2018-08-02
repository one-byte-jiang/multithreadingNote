package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.ThreadSafe;

/**
 * 饿汉式 单例的示例在类装载的时候创建
 * */
@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5(){
        //私有化构造器
    }
    private static SingletonExample5 singletonExample2 = null;//这个变量必须在static块前面
    static {
        //通过静态块进行初始化
        singletonExample2= new SingletonExample5();
    }
    public static SingletonExample5 getSingletonExample2(){
        return singletonExample2;
    }
}
