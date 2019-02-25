package me.zy.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

/*账单*/
public class Bill {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public int getSumCents(){
        return items.stream().mapToInt(items-> items.getPrice()).sum();
    }

    public void pay(IPaymentMethod paymentMethod){
        paymentMethod.Pay(getSumCents());
    }
}
