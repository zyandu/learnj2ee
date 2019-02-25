package me.zy.pattern.strategy;

public class StrategyDemo {

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("设计模式六原则",10000));
        bill.addItem(new Item("设计模式",20000));

        bill.pay(PaymentMethodFactory.getPaymentMethod("alipay"));
    }
}
