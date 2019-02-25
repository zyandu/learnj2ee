package me.zy.pattern.strategy;

public interface IPaymentMethod {
    /*
    * 支付
    * cents:金额，单位分
    * */
    void Pay(int cents);
}
