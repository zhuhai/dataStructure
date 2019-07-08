package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/8
 * Time: 11:44
 *
 * @author: zhuhai
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int head;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal capacity.");
        }
        data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    @Override
    public void enqueue(E e) {
        //如果队列满了，则进行扩容
        if ((tail + 1) % data.length == head) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;

    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        E ret = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        sb.append("head [");
        for (int i = head; i != tail ; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }





}
