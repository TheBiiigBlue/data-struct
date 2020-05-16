package com.bigblue.video.chapter4_linkedlist;

import com.bigblue.video.chapter3_stack_queue.queue.MyQueue;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/30
 */
public class D_LinkedListQueue<E> implements MyQueue<E> {

    /**
     * 由于队列是一头进一头出，只有一个head节点还需要循环
     * 所以增加tail指针，并且从tail入栈，从head出栈
     * 因为从tail入栈的话需要找到上一个节点，还是需要循环
     */
    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public D_LinkedListQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            head = tail = new Node(e, null);
        } else {
            tail = tail.next = new Node(e, null);
        }
        size++;
    }

    @Override
    public E dequeue() {
        checkEmpty();
        Node delNode = head;
        head = head.next;
        if(head == null){
            head = tail = null;
        }
        delNode.next = null;
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        checkEmpty();
        return head.e;
    }

    private void checkEmpty() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue Is Empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedListQueue: size = %d\nTOP\t", getSize()));
        Node curr = this.head;
        for (int i = 0; i < size; i++) {
            sb.append(curr.e).append("-->");
            curr = curr.next;
        }
        sb.append("NULL\tTAIL");
        return sb.toString();
    }

}
