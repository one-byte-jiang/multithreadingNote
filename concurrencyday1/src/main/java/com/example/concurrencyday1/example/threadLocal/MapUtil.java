package com.example.concurrencyday1.example.threadLocal;

import com.example.concurrencyday1.example.singleton.SingletonExample2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapUtil {
    private final static Map<String,Object> map = new ConcurrentHashMap<String,Object>();

    static {
        SingletonExample2 singletonExample2 = new SingletonExample2();
        //静态代码块只会只会一次，线程安全
        map.put("obj",singletonExample2);
    }
    /*获取对象*/
    public static synchronized Object getObj(){
        if(map.get("obj")==null){
            //如果等于null,可以选择等待，频繁去new的话会造成内存负荷，特别是高并发情况
            return new SingletonExample2();
        }
        else{
            Object obj = map.get("obj");
            map.remove("obj");
            return obj;
        }
    }

    /*用完对象后进行回收*/
    public static synchronized  void closeObj(Object obj){
        //用完之后，我会把之前取出去的对象再放回去
        if(map.get("obj")==null)
            map.put("obj",obj);
    }
}
