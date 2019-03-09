package me.zy.pattern.factory.abstractfactory;

public class DasEngine implements IEngine {
    @Override
    public void makeEngine() {
        System.out.println("生成Das引擎");
    }
}
