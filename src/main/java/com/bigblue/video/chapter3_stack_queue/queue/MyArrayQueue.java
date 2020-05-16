package com.bigblue.video.chapter3_stack_queue.queue;

import com.bigblue.video.chapter2_array.MyArray;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public class MyArrayQueue<E> implements MyQueue<E> {

    private MyArray<E> array;

    public MyArrayQueue () {
        array = new MyArray<E>();
    }

    public MyArrayQueue (int capacity){
        array = new MyArray<E>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\nFront\t[", getSize(), getCapacity()));
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i != getSize()  - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\t Tail");
        return sb.toString();
    }
}
