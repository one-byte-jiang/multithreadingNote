package com.example.concurrencyday1.example.atomic;

import com.example.concurrencyday1.annoation.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class AtomicReference4 {
    private static AtomicReference<Integer> count = new AtomicReference(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);//是0的时候更新成2
        count.compareAndSet(0,1);//是0的时候更新成1
        count.compareAndSet(1,3);//是1的时候更新成3
        count.compareAndSet(2,4);//是2的时候更新成4
        count.compareAndSet(3,5);//是3的时候更新成5
        System.out.println("count:"+count.get());

    }
}
