package me.zy.thread;

public class BadResume {
    public static class ChangeObjectThread extends Thread{
        @Override
        public void run(){
            System.out.println("in" + getName());
            Thread.currentThread().resume();
        }
    }
}
