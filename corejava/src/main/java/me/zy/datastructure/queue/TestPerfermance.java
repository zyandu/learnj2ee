package me.zy.datastructure.queue;

import java.util.Random;

public class TestPerfermance {
    public static double executeTm(Queue<Integer> q, int execCounts){
        long startTime = System.currentTimeMillis();


        Random random = new Random(Integer.MAX_VALUE);
        for (int i = 0; i < execCounts; i++) {
            q.enqueue(random.nextInt());
            q.dequeue();
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = executeTm(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = executeTm(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

    }
}
