package me.zy.thread;

public class BasicInterfaceThread implements Runnable {
    @Override
    public void run() {
        System.out.println("准备就绪"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new BasicInterfaceThread()).start();
        new BasicInterfaceThread().run();
    }

}
