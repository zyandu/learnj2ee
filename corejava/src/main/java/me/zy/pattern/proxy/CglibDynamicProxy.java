package me.zy.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {
    private Object target;//被代理对象

    public Object getInstance(Object target) {
        this.target = target;

        //加强器：用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为创建的动态代理类执行父类
        enhancer.setSuperclass(target.getClass());
        //回调
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理在被代理执行方法前的演示");
        Object result = methodProxy.invokeSuper(o,objects);

        return result;
    }
}
