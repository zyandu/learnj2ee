package me.zy.pattern.decorator;

public class ThreeDComputer extends GameComputer {
    @Override
    public String ability() {
        return super.ability()+"再配上画图板，变成3D制图电脑。";
    }

    @Override
    protected int price() {
        return super.price()+1000;
    }
}
