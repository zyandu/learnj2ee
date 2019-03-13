package me.zy.pattern.proxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class PaymentClient {


    public static void main(String[] args) {
        //IPayMent payMent = new AliPayProxy();
        //System.out.println(payMent.doPay("zy"));
        //
        //IPayMent pay = new AliPayImpl();
        //JdkDynamicProxy proxy = new JdkDynamicProxy();
        //IPayMent p1 = (IPayMent)proxy.bind(pay,pay.getClass().getInterfaces());
        //System.out.println(p1.doPay("ZYDy"));

        //byte[] classFile = sun.misc.ProxyGenerator.

        //cglib动态代理一个类，静态代理只能代理接口类
        //设置参数，将生成的字节码文件保存在对应路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"corejava/src/test/pattern/proxy");
        AliPayImpl aliPay = new AliPayImpl();
        CglibDynamicProxy proxy = new CglibDynamicProxy();
        AliPayImpl p2 = (AliPayImpl)proxy.getInstance(aliPay);
        p2.doPay("zycgl");

        //静态代理：
        //jdk动态代理：通过接口的方法名（继承Proxy类，实现被代理接口类方法）动态生成代理类，通过反射调用代理类同名方法进行拦截
        //cglib：继承具体的代理业务类，动态生成新的子类，重写业务类方法进行拦截实现
        //asm
        //javasist

    }
}
