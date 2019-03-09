package me.zy.pattern.factory.abstractfactory;

public class BwmCar implements ICarAbstractFactory {
    @Override
    public IEngine createEngine() {
        return new BmwEngine();
    }

    @Override
    public ICarBody createCarBody() {
        return new BmwBody();
    }
}
