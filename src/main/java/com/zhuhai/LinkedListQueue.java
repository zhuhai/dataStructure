package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/10
 * Time: 16:35
 *
 * @author: zhuhai
 */
public class LinkedListQueue<E> implements Queue<E> {

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
    private Node tail;
    private int size;


    @Override
    public void enqueue(E e) {
        //队列为空时
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: top: ");
        Node current = head;
        while (current != null) {
            sb.append(current + "—>");
            current = current.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue.getFront());
    }
}
