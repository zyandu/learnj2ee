package me.zy.pattern.factory.simplefactory;

public class BmwCar implements ICar {
    @Override
    public void makeCar() {
        System.out.println("生产了BMW汽车");
    }
}
