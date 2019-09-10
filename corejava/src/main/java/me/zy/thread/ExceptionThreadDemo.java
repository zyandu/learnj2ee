package me.zy.thread;

import java.util.concurrent.TimeUnit;

public class ExceptionThreadDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                try {
                    //中断一个阻塞状态的线程，会抛异常
                    //wait、sleep、join阻塞，需要外部触发进行释放
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;//退出循环
                }
                System.out.println("demo is running.");
            }
            System.out.println("i:"+i);
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("isInterrupted:"+thread.isInterrupted());

    }
}
