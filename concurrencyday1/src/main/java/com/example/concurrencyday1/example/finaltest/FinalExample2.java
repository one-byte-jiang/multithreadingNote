package com.example.concurrencyday1.example.finaltest;

import com.example.concurrencyday1.annoation.NotThreadSafe;
import com.example.concurrencyday1.annoation.ThreadSafe;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

@ThreadSafe
public class FinalExample2 {
    private  static Map<Integer,Integer> map  = Maps.newHashMap();
    static {
        map.put(1,1);
        map.put(2,2);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
    }
}
