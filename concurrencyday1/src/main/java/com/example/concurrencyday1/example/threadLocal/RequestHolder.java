package com.example.concurrencyday1.example.threadLocal;

import com.example.concurrencyday1.example.singleton.SingletonExample2;

public class RequestHolder {
    private final static ThreadLocal<Long> requstHolder = new ThreadLocal<>();
    private final static ThreadLocal<SingletonExample2> threadObj = new ThreadLocal<>();

    public static void add(Long id){
        requstHolder.set(id);
    }
    public static Long getId(){
        return  requstHolder.get();
    }

    public static void remove(){
        requstHolder.remove();
    }

    public static void set(SingletonExample2 singletonExample2){
        threadObj.set(singletonExample2);
    }
    public static SingletonExample2 getObj(){
       return threadObj.get();
    }
    public static void removeObj(){
        threadObj.remove();
    }
}
