package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/7
 * Time: 16:07
 *
 * @author: hai
 */
public class TestStack {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
