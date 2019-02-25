package me.zy.pattern.proxy;

//静态代理只能代理这一类对象
//如果要代理多个对象，需要实现多个类,代理类会很多，难以维护
//动态代理可以解决上述问题
public class AliPayProxy implements IPayMent {
    //构件或者传递进来，被代理的对象
    //父类的引用指向子类对象
    private IPayMent payMent = new AliPayImpl();

    public String doPay(String args) {
        System.out.println("支付前记录日志");
        return payMent.doPay("zy");
    }
}
