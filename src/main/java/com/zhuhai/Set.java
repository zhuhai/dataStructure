package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/23
 * Time: 16:34
 *
 * @author: zhuhai
 */
public interface Set<E> {
    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();


}
