package me.zy.pattern.factory.abstractfactory;

public class DasCar implements ICarAbstractFactory {
    @Override
    public IEngine createEngine() {
        return new DasEngine();
    }

    @Override
    public ICarBody createCarBody() {
        return new DasBody();
    }
}
