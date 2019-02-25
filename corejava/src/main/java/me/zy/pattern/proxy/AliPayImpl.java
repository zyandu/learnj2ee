package me.zy.pattern.proxy;

public class AliPayImpl implements IPayMent {
    public String doPay(String uid) {
        System.out.println("uid->"+uid+"使用支付宝支付");
        return "success";
    }
}
