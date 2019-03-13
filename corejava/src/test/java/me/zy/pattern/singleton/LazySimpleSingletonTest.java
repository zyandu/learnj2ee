package me.zy.pattern.singleton;

public class LazySimpleSingletonTest {

    public static void main(String[] args) {
        Thread et1 = new Thread(new ExecutorThread());
        Thread et2 = new Thread(new ExecutorThread());

        et1.start();
        et2.start();

        System.out.println("Executor end.");

    }
}
