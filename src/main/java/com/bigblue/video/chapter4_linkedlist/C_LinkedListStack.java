package com.bigblue.video.chapter4_linkedlist;

import com.bigblue.video.chapter3_stack_queue.stack.MyStack;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/30
 */
public class C_LinkedListStack<E> implements MyStack<E> {

    /**
     * 使用虚拟头结点的方式实现栈
     */
    private B_DummyHeadLinkedList<E> linkedList;

    public C_LinkedListStack() {
        linkedList = new B_DummyHeadLinkedList<E>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peak() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedListStack: size = %d\nTOP\t", getSize()));
        sb.append(linkedList);
        return sb.toString();
    }
}
