package me.zy.pattern.factory.abstractfactory;

public class BmwEngine implements IEngine {
    @Override
    public void makeEngine() {
        System.out.println("生成BWM引擎");
    }
}
