package me.zy.pattern.delegate.simple;

public class SimpleDelegateTest {
    public static void main(String[] args) {
        Boss b = new Boss();
        Leader l = new Leader();
        b.command(l,"后台");
    }
}
