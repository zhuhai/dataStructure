package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/7
 * Time: 15:39
 *
 * @author: hai
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

}
