package me.zy.pattern.factory.simplefactory;

public class SimpleFactory {
    public static ICar getCarByName(String carName){
        if(carName.equals("BMW")){
            return new BmwCar();
        }else if(carName.equals("DAS")){
            return new DasCar();
        }

        return null;
    }
}
