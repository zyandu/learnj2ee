package me.zy.pattern.factory.simplefactory;

public class DasCar implements ICar {
    @Override
    public void makeCar() {
        System.out.println("生成Das汽车");
    }
}
