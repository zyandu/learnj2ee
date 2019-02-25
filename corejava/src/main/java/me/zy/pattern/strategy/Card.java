package me.zy.pattern.strategy;

public abstract class Card implements IPaymentMethod{
    @Override
    public void Pay(int cents) {
        //用什么卡支付了多少钱
        System.out.println("use"+getType()+"->payed"+cents+"cents");

        executeTransaction(cents);//具体去实现支付
    }

    //抽象类中定义公共模板方法，具体实现类去实现
    protected abstract String  getType();

    protected abstract void executeTransaction(int cents);

}
