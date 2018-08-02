package com.example.concurrencyday1.example.publish;

import com.example.concurrencyday1.annoation.NotRecommend;
import com.example.concurrencyday1.annoation.NotThreadSafe;

/**
 * 对象溢出
 * */
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;
    public Escape(){
        new InnerClass();
    }
    private class InnerClass{
        //内部类
        public InnerClass(){
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
