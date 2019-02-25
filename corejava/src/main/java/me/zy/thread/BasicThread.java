package me.zy.thread;

public class BasicThread extends Thread {
    @Override
    public void run(){
        while(true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Current thread interrupted!");
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread interrupted when sleep.");
                //异常，清除中断标记
                Thread.currentThread().interrupt();
            }
        }
    }
}
