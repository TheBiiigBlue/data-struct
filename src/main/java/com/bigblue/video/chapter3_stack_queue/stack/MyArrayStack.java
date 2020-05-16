package com.bigblue.video.chapter3_stack_queue.stack;

import com.bigblue.video.chapter2_array.MyArray;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public class MyArrayStack<E> implements MyStack<E> {

    private MyArray<E> array;

    public MyArrayStack() {
        array = new MyArray<E>();
    }

    public MyArrayStack(int capacity) {
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

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peak() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Stack: ["));
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i != getSize()  - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\t Peak");
        return sb.toString();
    }
}
