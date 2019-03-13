package me.zy.pattern.prototype;

public class ProtoTypeTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColor("white");
        car.setName("mini");

        //CarModel cm = (CarModel)car.clone();
        //cm.setSize(100);

        //System.out.println(cm.getColor()+","+cm.getName()+","+cm.getSize());

    }
}
