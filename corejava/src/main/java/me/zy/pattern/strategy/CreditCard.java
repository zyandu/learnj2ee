package me.zy.pattern.strategy;

public class CreditCard extends Card {
    @Override
    public void Pay(int cents) {
        super.Pay(cents);
    }

    @Override
    protected String getType() {
        return "credit";
    }

    @Override
    protected void executeTransaction(int cents) {
        System.out.println("doTransaction with credit :"+cents);
    }
}
