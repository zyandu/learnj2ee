package me.zy.pattern.factory.abstractfactory;

public interface ICarAbstractFactory {
    IEngine createEngine();

    ICarBody createCarBody();
}
