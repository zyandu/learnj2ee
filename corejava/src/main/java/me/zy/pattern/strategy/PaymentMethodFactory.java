package me.zy.pattern.strategy;

public class PaymentMethodFactory {

    public static Card getPaymentMethod(String payType){
        switch(payType){
            case "credit":
                return new CreditCard();
            case "alipay":
                return new AliPay();
            default:
                throw new RuntimeException("Can't find paymentMethod.");
        }
    }
}
