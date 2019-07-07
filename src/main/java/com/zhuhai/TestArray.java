package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/5
 * Time: 23:22
 *
 * @author: hai
 */
public class TestArray {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(5);
        for (int i = 0; i < 5; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(0, 100);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);

    }


}
