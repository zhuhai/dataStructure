package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/9
 * Time: 11:15
 *
 * @author: zhuhai
 */
public class LinkedList<E> {

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

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e) {
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        //这句代码等价于上面三句代码
        head = new Node(e, head);

        size++;

    }

    public void add(int index, E e) {
       if (index < 0 || index > size) {
           throw new IllegalArgumentException("add failed, Illegal index.");
       }
       if (index == 0) {
           addFirst(e);
       } else {
           Node pre = head;
           for (int i = 0; i < index - 1; i++) {
               pre = pre.next;
           }
           /*Node node = new Node(e);
           node.next = pre.next;
           pre.next = node;*/
           //等同于上面三句
           pre.next = new Node(e, pre.next);
           size++;
       }


    }

    public void addLast(E e) {
        add(size, e);
    }



}
