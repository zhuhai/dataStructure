package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/7
 * Time: 23:34
 *
 * @author: hai
 */
public interface Queue<E> {
    void enQueue(E e);
    E deQueue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
