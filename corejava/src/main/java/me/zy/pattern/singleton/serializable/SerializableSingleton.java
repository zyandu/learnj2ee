package me.zy.pattern.singleton.serializable;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private SerializableSingleton(){}

    private static final SerializableSingleton INSTANCE = new SerializableSingleton();

    public static SerializableSingleton getInstance(){
       return INSTANCE;
   }

    //重写此方法，可以解决序列化破坏单例的问题
    //原理：ObjectInputStream在创建初始化实例对象之后，会调用readResolve方法
    // if (obj != null &&
    //        handles.lookupException(passHandle) == null &&
    //        desc.hasReadResolveMethod())
    //{
    //    Object rep = desc.invokeReadResolve(obj);
    //重新此方法，只是覆盖了反序列化的对象，但是还是创建了两次
    //但是此行为发生在JVM层面，相对来说比较安全
    //之前反序列化的对象会被GC回收
    private Object readResolve(){
        return INSTANCE;
    }

}
