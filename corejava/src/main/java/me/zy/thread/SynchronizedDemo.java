package me.zy.thread;

/**
 * 既要保证数据安全性，又想要提升性能
 * 两种作用范围：对象锁、类锁，是否跨对象跨线程保护
 * 两种表现形式
 */
public class SynchronizedDemo {
    //对象锁
    public synchronized void demo(){

    }

    public void demo2(){
        //this这个对象的生命周期，也是对象锁
        synchronized (this){
            //这里书写需要加锁的代码
        }
        //括号外可以书写无需加锁的代码实现
    }

    //demo3、demo4作用域是全局的；
    public synchronized static void demo3(){

    }

    public void deom4(){
        synchronized (SynchronizedDemo.class){

        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();
        //两个不同对象，锁不是全局锁，所以不存在线程安全问题
        //而demo3、demo4就存在线程安全问题
        new Thread(()->synchronizedDemo1.demo()).start();
        new Thread(()->synchronizedDemo2.demo2()).start();
        new Thread(()->synchronizedDemo1.demo3()).start();
        new Thread(()->synchronizedDemo2.deom4()).start();
    }

}
