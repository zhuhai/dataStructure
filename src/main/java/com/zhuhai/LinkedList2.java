package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/9
 * Time: 16:09
 *
 * @author: zhuhai
 */
public class LinkedList2<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList2() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, Illegal index");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

}
