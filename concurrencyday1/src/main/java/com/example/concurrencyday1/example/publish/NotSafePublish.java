package com.example.concurrencyday1.example.publish;

import com.example.concurrencyday1.annoation.NotThreadSafe;

import java.util.Arrays;

/**
 * 发布对象，不能保证其他线程会对状态数组修改，不能让线程修改状态数组
 * */
@NotThreadSafe
public class NotSafePublish {
    private String[] state = {"da","jiang","ge"};
    public String[] getState(){
        return state;
    }

    public static void main(String[] args) {
        NotSafePublish notSafePublish = new NotSafePublish();
        System.out.println("当前数组的值为："+ Arrays.toString(notSafePublish.getState()));
        //我们尝试对私有属性进行修改
        notSafePublish.getState()[0]="update";
        System.out.println("当前数组的值为："+ Arrays.toString(notSafePublish.getState()));
    }
}
