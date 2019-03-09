package me.zy.pattern.factory.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        BwmCar factory = new BwmCar();
        factory.createEngine().makeEngine();
        factory.createCarBody().makeBody();
    }
}
