package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/29
 * Time: 11:47
 *
 * @author: zhuhai
 */
public interface Map<K, V> {

    void put(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V value);
    boolean isEmpty();
    int getSize();

}
