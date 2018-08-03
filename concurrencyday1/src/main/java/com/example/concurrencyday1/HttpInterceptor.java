package com.example.concurrencyday1;

import com.example.concurrencyday1.example.threadLocal.RequestHolder;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //处理之前
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //处理之后
        RequestHolder.remove();
        RequestHolder.removeObj();
        System.out.println("afterCompletion");
        return;
    }
}
