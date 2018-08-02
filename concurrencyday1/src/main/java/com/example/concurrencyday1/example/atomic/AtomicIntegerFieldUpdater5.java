package com.example.concurrencyday1.example.atomic;

import com.example.concurrencyday1.annoation.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@ThreadSafe
public class AtomicIntegerFieldUpdater5 {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdater5> updater  =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdater5.class,"count");
    private volatile  int count = 100;//必须通过volatile关键字修饰才可以
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater5 updater5 = new AtomicIntegerFieldUpdater5();
        if(updater.compareAndSet(updater5,100,120)){//如果这个对象里面的值是100，就更新成120
            System.out.println("updater success"+updater5.getCount());
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
