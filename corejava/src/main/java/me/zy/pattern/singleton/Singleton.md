## 单例模式
### 定义
* 单例模式是指确保一个类在任何情况下都绝对只有一个实例，并提供一个全局访问点。

### 特征
* 隐藏所有构造方法
* 属于创建型模式

### 适用场景
* 确保任何情况下都绝对只有一个实例。
* ServletContext、ServletConfig、ApplicationContext、DBPool

### 常见写法
#### 饿汉式单例：
* 在单例类首次加载时就创建实例。
* 缺点：浪费内存空间，不管是否使用，都创建实例。
```JAVA
public class HungrySingleton {
    //final不会被修改
    private static final HungrySingleton singleton =
            new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return singleton;
    }
}

//静态实现
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
```

#### 懒汉式单例
* 被外部类调用时才创建实例。
##### 懒汉式：
```JAVA
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

        //这里可能有线程安全问题，所以方法上加了synchronized
        //两个线程同时进入，就会new两次
        if(null == lazySineleton){
            lazySineleton = new LazySimpleSingleton();
        }

        return lazySineleton;
    }
}

```
##### 双重检查锁实现方式：
```JAVA
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

```
##### 内部类实现：
```JAVA
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
```

#### 序列化与反序列化单例
```JAVA
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

public class SerializableSingletonTest {
    public static void main(String[] args) {
        SerializableSingleton instance = SerializableSingleton.getInstance();

        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("corejava/src/test/SerializableSingleton.obj"));
            oos.writeObject(instance);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("corejava/src/test/SerializableSingleton.obj"));
            SerializableSingleton instance1 = (SerializableSingleton)ois.readObject();
            ois.close();

            System.out.println(instance == instance1);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
```
#### 注册式单例
* 将每一个实例都缓存到统一的容器中，使用唯一标识获取实例。
##### 枚举式注册单例
```JAVA
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
```
##### 容器缓存注册单例
```JAVA
package me.zy.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className){
        //防止线程不安全
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className);
                    ioc.put(className, obj);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }

}
```

#### ThreadLocal单例
```JAVA
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
```