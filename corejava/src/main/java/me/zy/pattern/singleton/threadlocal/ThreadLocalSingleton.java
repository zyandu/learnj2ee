package me.zy.pattern.singleton.threadlocal;

//伪线程安全
//线程内安全
//线程间不安全
public class ThreadLocalSingleton {
    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
        new ThreadLocal<ThreadLocalSingleton>(){
            @Override
            protected ThreadLocalSingleton initialValue() {
                return new ThreadLocalSingleton();
            }
        };

    public static final ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

}
