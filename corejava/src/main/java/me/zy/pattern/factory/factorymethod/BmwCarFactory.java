package me.zy.pattern.factory.factorymethod;

import me.zy.pattern.factory.simplefactory.BmwCar;
import me.zy.pattern.factory.simplefactory.ICar;

public class BmwCarFactory implements ICarFactory {
    @Override
    public ICar getCarFactory() {
        return new BmwCar();
    }
}
