package me.zy.pattern.factory.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        //运行结果：“生成Das汽车”
        SimpleFactory.getCarByName("DAS").makeCar();
    }
}
