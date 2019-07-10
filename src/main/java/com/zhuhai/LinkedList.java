package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/9
 * Time: 16:09
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

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    /**
     * 在指定位置插入元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, Illegal index");
        }
        Node pre = dummyHead;
        //遍历出需要插入的索引的前一个节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        /*Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;*/
        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 在链表头部插入元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾部插入元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed, Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;

    }

    /**
     * 获取链表第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 判断链表中是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;

    }

    /**
     * 修改链表指定位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed, Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, Illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node ret = pre.next;
        pre.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    /**
     * 删除链表中第一元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表中最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除链表中指定的元素
     * @param e
     */
    public void removeElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                break;
            }
            pre = pre.next;
        }
        if (pre.next != null) {
            Node ret = pre.next;
            pre.next = ret.next;
            ret.next = null;
            size--;
        }


    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            sb.append(current + "—>");
            current = current.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkList.addLast(i);
        }
        System.out.println(linkList.toString());
        linkList.addFirst(222);
        System.out.println(linkList.toString());
        linkList.add(2, 666);
        System.out.println(linkList.toString());
        linkList.set(1, 2);
        System.out.println(linkList.toString());

        System.out.println(linkList.contains(666));
        linkList.removeElement(666);
        System.out.println(linkList.toString());
        linkList.removeFirst();
        System.out.println(linkList.toString());
        linkList.removeLast();
        System.out.println(linkList.toString());

    }
}
