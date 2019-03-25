package me.zy.pattern.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Computer c = new Computer();
        System.out.println(c.ability()+c.price());

        GameComputer gc = new GameComputer();
        System.out.println(gc.ability()+gc.price());

        ThreeDComputer tdc = new ThreeDComputer();
        System.out.println(tdc.ability()+tdc.price());
    }
}
