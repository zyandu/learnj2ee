package me.zy.pattern.singleton;

import me.zy.pattern.singleton.innerclass.LazyInnerClassSingleton;

public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        //LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
        //System.out.println(Thread.currentThread().getName()+":"+lazySimpleSingleton);


        LazyInnerClassSingleton innerClassSingleton = LazyInnerClassSingleton.getinstance();
        System.out.println(Thread.currentThread().getName()+"："+innerClassSingleton);
    }
}
