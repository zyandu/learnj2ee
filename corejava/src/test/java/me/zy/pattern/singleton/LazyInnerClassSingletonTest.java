package me.zy.pattern.singleton;

import me.zy.pattern.singleton.innerclass.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = LazyInnerClassSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);//强制访问

        Object o = constructor.newInstance();
        Object o1 = LazyInnerClassSingleton.getinstance();

        System.out.println(o == o1);//结果：false
    }
}
