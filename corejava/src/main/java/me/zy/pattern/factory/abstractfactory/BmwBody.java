package me.zy.pattern.factory.abstractfactory;

public class BmwBody implements ICarBody {
    @Override
    public void makeBody() {
        System.out.println("生成了BWM车体");
    }
}
