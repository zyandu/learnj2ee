package me.zy.pattern.singleton.innerclass;

//没有用到锁
//性能最优的一种写法
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton(){
        //防止反射攻击
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("已创建过实例");
        }
    }

    //懒汉式单例
    //LazyHolder里面的逻辑需要等到外部方法调用时才执行
    //巧妙地利用了内部类的特性（初始化外部类，先加载内部类）
    //JVM底层执行逻辑，完美避免了线程安全问题
    public static final LazyInnerClassSingleton getinstance(){
        return LazyHolder.LAZY;
    }

    //内部类
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
