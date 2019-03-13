package me.zy.pattern.singleton.lazy;

public class LazySimpleSingleton {
    //这里声明不能再加final修饰符，否则后面无法更改
    private static LazySimpleSingleton lazySineleton = null;

    private LazySimpleSingleton(){}

    //synchronized修饰符，就可以避免线程安全问题
    //JDK1.8以后对synchronized进行了优化
    //但是还是不可避免的的有一定的性能问题
    //这里可能会锁整个类对象
    public synchronized static LazySimpleSingleton getInstance(){

        //这里可能有线程安全问题，两个线程同时进入，就会new两次
        if(null == lazySineleton){
            lazySineleton = new LazySimpleSingleton();
        }

        return lazySineleton;
    }
}
