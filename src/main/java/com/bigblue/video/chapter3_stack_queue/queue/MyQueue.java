package com.bigblue.video.chapter3_stack_queue.queue;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public interface MyQueue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
