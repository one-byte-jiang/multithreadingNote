package com.example.concurrencyday1;

import com.example.concurrencyday1.example.singleton.SingletonExample2;
import com.example.concurrencyday1.example.threadLocal.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        System.out.println("当前线程ID："+Thread.currentThread().getId()+"---"+req.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        RequestHolder.set(SingletonExample2.getSingletonExample2());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
