package com.example.concurrencyday1.example.singleton;

import com.example.concurrencyday1.annoation.ThreadSafe;

/**
 * 饿汉式 单例的示例在类装载的时候创建
 * */
@ThreadSafe
public class SingletonExample2 {
    private String name;
    private String age;
    /*private SingletonExample2(){
        //私有化构造器
    }*/
    private static SingletonExample2 singletonExample2 = new SingletonExample2();
    public static SingletonExample2 getSingletonExample2(){
        return singletonExample2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingletonExample2{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
