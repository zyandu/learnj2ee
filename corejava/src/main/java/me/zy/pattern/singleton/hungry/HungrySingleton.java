package me.zy.pattern.singleton.hungry;

public class HungrySingleton {
    //final不会被修改
    private static final HungrySingleton singleton =
            new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return singleton;
    }
}
