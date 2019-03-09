package me.zy.pattern.factory.abstractfactory;

public class DasBody implements ICarBody{
    @Override
    public void makeBody() {
        System.out.println("生成了DAS车体");
    }
}
