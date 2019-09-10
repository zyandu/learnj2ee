package me.zy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicCallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        return "call is running: "+Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        BasicCallableThread basicCallableThread = new BasicCallableThread();
        Future<String> future = (Future<String>) es.submit(basicCallableThread);
        System.out.println(future.get());

        es.shutdown();
    }
}
