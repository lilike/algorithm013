package com.lilike.daily;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author llk
 * @Date 2020/11/5 11:53
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public class TestExecutor {

    public static void main(String[] args) throws Exception {

        System.out.println("我是主线程---------start");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Future<Integer> submit = executor.submit(() -> {
                int time = Double.valueOf(Math.floor(10000 * finalI * new Random().nextDouble())).intValue();
                System.out.println(Thread.currentThread().getName() + "start" + "业务处理需要:" + time + "ms");
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName() + "end");
                return finalI;
            });
            futures.add(submit);
        }
        System.out.println("我是主线程---------mid");

        while (!futures.isEmpty()) {
            Iterator<Future<Integer>> it = futures.iterator();
            while (it.hasNext()) {
                Future<Integer> future = it.next();
                if (future.isDone()) {
                    System.out.println(future.get());
                    it.remove();
                }
            }
        }
        System.out.println("我是主线程---------end");


        executor.shutdown();

    }


}
