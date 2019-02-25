package me.zy.pattern.strategy;

public class AliPay extends Card{
    @Override
    protected String getType() {
        return "AliPay";
    }

    @Override
    protected void executeTransaction(int cents) {
        System.out.println("doTransaction with Alipay:"+cents);

    }
}
