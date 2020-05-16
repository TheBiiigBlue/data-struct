package com.bigblue.video.chapter3_stack_queue.queue;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public class MyLoopQueue<E> implements MyQueue<E> {

    private E[] data;
    private int front, tail, size;

    public MyLoopQueue() {
        this(10);
    }

    public MyLoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty");
        }
        E retEle = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return retEle;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity + 1];
//        int index = 0;
//        for (int i = front; i != tail; i = (i + 1) % data.length) {
//            newArr[index++] = data[i];
//        }
//        tail = index;
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length];
        }
        tail = size;
        front = 0;
        data = newArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\nFront\t[", size, getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("]\t Tail");
        return sb.toString();
    }
}