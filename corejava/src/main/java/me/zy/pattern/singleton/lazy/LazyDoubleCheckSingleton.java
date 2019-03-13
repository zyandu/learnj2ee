package me.zy.pattern.singleton.lazy;

public class LazyDoubleCheckSingleton {
    //volatile排除指令重排序带来的线程不安全因素
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        //适中方案，不会锁整个类
        if(lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                //再次判断，双重检查锁
                //保证多个线程不会再次进入new对象
                if(lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
