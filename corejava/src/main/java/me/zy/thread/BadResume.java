package me.zy.thread;

/*
* 过期的suspend()挂起、resume()继续执行线程，这两个操作就好比播放器的暂停和恢复。
* 但这两个 API 是过期的，也就是不建议使用的。
* 不推荐使用 suspend() 去挂起线程的原因，是因为 suspend() 在导致线程暂停的同时，并不会去释放任何锁资源。
* 其他线程都无法访问被它占用的锁。直到对应的线程执行 resume() 方法后，被挂起的线程才能继续，从而其它被阻塞在这个锁的线程才可以继续执行。
* 但是，如果 resume() 操作出现在 suspend() 之前执行，那么线程将一直处于挂起状态，同时一直占用锁，这就产生了死锁。
* 而且，对于被挂起的线程，它的线程状态居然还是 Runnable。
* */
public class BadResume {
    public static class ChangeObjectThread extends Thread{
        @Override
        public void run(){
            System.out.println("in" + getName());
            Thread.currentThread().resume();
        }
    }
}
