package com.zhuhai;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/7
 * Time: 16:07
 *
 * @author: hai
 */
public class TestStack {

    public static void main(String[] args) {
        int count = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = test(arrayStack, count);
        System.out.println("time1: " + time1);
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = test(linkedListStack, count);
        System.out.println("time2: " + time2);
    }


    private static double test(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();

        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}
