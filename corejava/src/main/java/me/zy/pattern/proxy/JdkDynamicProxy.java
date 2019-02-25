package me.zy.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理只能代理这一类对象
 * 如果要代理多个对象，需要实现多个类,代理类会很多，难以维护
 * 动态代理可以解决上述问题
 *
 * java自带的代理实现，没法动态代理一个类（动态代理会继承Proxy类，所以没法再次继承）
 * 非接口的实现没法使用java自带的代理，可以使用Cglib(spring提供两种代理方式)
 */
public class JdkDynamicProxy implements InvocationHandler{
    private Object target;//被代理的对象

    public Object bind(Object target,Class[] interfaces){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理调用目标对象方法前可以做一些操作");

        //反射调用方法
        return method.invoke(target,args);

    }
}
