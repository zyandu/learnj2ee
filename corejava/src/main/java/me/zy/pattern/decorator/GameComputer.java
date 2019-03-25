package me.zy.pattern.decorator;

public class GameComputer extends Computer {
    @Override
    public String ability() {
        return super.ability()+"加上独显，变成游戏PC。";
    }

    @Override
    protected int price() {
        return super.price()+1500;
    }
}
