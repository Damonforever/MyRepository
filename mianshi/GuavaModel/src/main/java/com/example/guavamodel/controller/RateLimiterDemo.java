package com.example.guavamodel.controller;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/27 15:05
 */
public class RateLimiterDemo {
    static RateLimiter limiter = RateLimiter.create(2);
    public static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            //会阻塞，所有请求都会被执行
//            limiter.acquire();
//            new Thread(new Task()).start();
            //不会阻塞，丢弃其他全部的请求
            if (!limiter.tryAcquire()) continue;
            new Thread(new Task()).start();
        }
    }
}
