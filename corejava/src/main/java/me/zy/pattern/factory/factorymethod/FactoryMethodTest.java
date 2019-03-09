package me.zy.pattern.factory.factorymethod;

public class FactoryMethodTest {

    public static void main(String[] args) {
        //运行结果：生产了BMW汽车
        ICarFactory carFactory = new BmwCarFactory();
        carFactory.getCarFactory().makeCar();
    }
}
