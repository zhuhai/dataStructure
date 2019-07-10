package com.zhuhai;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/8
 * Time: 23:04
 *
 * @author: hai
 */
public class TestQueue {

    public static void main(String[] args) {
        int count = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = test(arrayQueue, count);
        System.out.println("ArrayQueue time: " + time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = test(loopQueue, count);
        System.out.println("LoopQueue time: " + time2);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = test(linkedListQueue, count);
        System.out.println("LinkedListQueue time: " + time3);


    }


    private static double test(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}
