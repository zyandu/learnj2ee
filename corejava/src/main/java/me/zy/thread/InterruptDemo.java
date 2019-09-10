package me.zy.thread;

import java.util.concurrent.TimeUnit;

/**
 * 如何优雅地关闭一个线程
 */
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        //把isInterrupted设置成true
        //运行结果
        //Process finished with exit code 0
        //如果不调用这个方法，那么线程就不会退出
        thread.interrupt();

    }
}
