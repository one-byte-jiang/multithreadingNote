package com.example.concurrencyday1.example.threadLocal;

import com.example.concurrencyday1.example.singleton.SingletonExample2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {
    @RequestMapping("/test")
    @ResponseBody
    public Long test(){
        return  RequestHolder.getId();
    }
    @RequestMapping("/test1")
    @ResponseBody
    public SingletonExample2 test1(String name) throws InterruptedException {
       /* SingletonExample2 obj = RequestHolder.getObj();*/
        SingletonExample2 obj = (SingletonExample2)MapUtil.getObj();
        /*SingletonExample2 obj = new SingletonExample2();*/
        System.out.println(obj.toString()+"-----------hashcode="+obj.hashCode());
        obj.setName(name);
        MapUtil.closeObj(obj);
        //System.out.println(obj.toString()+"-----------hashcode="+obj.hashCode());
        return  obj;
    }

}
