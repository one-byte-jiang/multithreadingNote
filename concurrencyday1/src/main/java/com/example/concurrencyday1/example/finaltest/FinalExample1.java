package com.example.concurrencyday1.example.finaltest;

import com.example.concurrencyday1.annoation.NotThreadSafe;
import com.google.common.collect.Maps;

import java.util.Map;

@NotThreadSafe
public class FinalExample1 {
    private final static int a=1;
    private final static String b  = "jiang";
    private final static Map<Integer,Integer> map  = Maps.newHashMap();
    static {
        map.put(1,1);
        map.put(2,2);
    }

    public static void main(String[] args) {
        /*a=2;
        b="2";
        map=Maps.newHashMap();*/
        //基本数据类型不允许更改成其他的值
        //引用数据类型不允许指向新的对象，但可以操作里面的数据
        map.put(1,5);
    }
}
