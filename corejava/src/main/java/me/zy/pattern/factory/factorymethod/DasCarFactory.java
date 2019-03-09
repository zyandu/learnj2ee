package me.zy.pattern.factory.factorymethod;

import me.zy.pattern.factory.simplefactory.DasCar;
import me.zy.pattern.factory.simplefactory.ICar;

public class DasCarFactory implements ICarFactory {
    @Override
    public ICar getCarFactory() {
        return new DasCar();
    }
}
