package me.zy.pattern.singleton.hungry;

public class HungryStaticSingleton {
    //final不会被修改
    private static final HungryStaticSingleton singleton;

    static{
        singleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return singleton;
    }
}
