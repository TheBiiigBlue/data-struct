package com.bigblue.video.chapter3_stack_queue.stack;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public interface MyStack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peak();
}
