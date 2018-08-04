package com.example.concurrencyday1.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample1 {
    //java.util.ConcurrentModificationException
    //如果要删除的操作，遍历的时候做好标记，结束之后再去删除
    public static  void test1(Vector<Integer> v1){
        for (Integer i:v1) {
            if(i.equals(3))
                v1.remove(i);
        }
    }
    //java.util.ConcurrentModificationException
    public static void test2(Vector<Integer> v2){
        Iterator<Integer> v1 = v2.iterator();
        while (v1.hasNext()){
            Integer i  = v1.next();
            if(i.equals(3))
                v2.remove(i);
        }
    }
    //成功
    public static  void test3(Vector<Integer> v3){
        for (int i = 0; i < v3.size(); i++) {
            if(i==3)
                v3.remove(i);
        }
    }

    public static void main(String[] args) {
        Vector<Integer> v = new Vector();
        v.add(1);
        v.add(2);
        v.add(3);
        test3(v);
   }
}
