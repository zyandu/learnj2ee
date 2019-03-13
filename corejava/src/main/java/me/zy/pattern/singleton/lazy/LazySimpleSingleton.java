package me.zy.pattern.singleton.lazy;

public class LazySimpleSingleton {
    //这里声明不能再加final修饰符，否则后面无法更改
    private static LazySimpleSingleton lazySineleton = null;

    private LazySimpleSingleton(){}

    public static LazySimpleSingleton getInstance(){

        if(null == lazySineleton){
            lazySineleton = new LazySimpleSingleton();
        }

        return lazySineleton;
    }
}
