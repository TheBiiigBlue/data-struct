package com.bigblue.video.chapter4_linkedlist;

import java.util.LinkedList;

/**
 * @Author: TheBigBlue
 * @Description: 双向链表
 * @Date: 2019/10/30
 */
public class F_TwoWayLinkedList<E> {

    private class Node {
        private Node pre;
        private E e;
        private Node next;
    }

    private Node head;
    private int size;

    public F_TwoWayLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }


    public void add(int index, E e) {
        //TODO
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        //TODO
        return null;
    }



}
