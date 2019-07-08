package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/7
 * Time: 23:34
 *
 * @author: hai
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
