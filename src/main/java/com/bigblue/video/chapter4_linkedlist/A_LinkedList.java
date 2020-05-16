package com.bigblue.video.chapter4_linkedlist;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/28
 */
public class A_LinkedList<E> {

    /**
     * 因为只有一个head标识头结点，所以从头部添加最快，但是有个问题，
     * 就是遍历的时候先拿出来的是最后插入的元素，即LIFO的模式了。。这是不应该的
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
    private int size;

    public A_LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    private void add(int index, E e) {
        checkIndex(index);
        if (index == 0) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
            head = new Node(e, head);
            size++;
        } else {
            Node preNode = getPreNode(index);
            preNode.next = new Node(e, preNode.next);
            size++;
        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    private E remove(int index) {
        checkIndex(index);
        checkEmpty();
        Node delNode = head;
        if (index == 0) {
            head = head.next;
            delNode.next = null;
            size--;
        } else {
            Node preNode = getPreNode(index);
            delNode = preNode.next;
            preNode.next = delNode.next;
            delNode.next = null;
            size--;
        }
        return delNode.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    private E get(int index) {
        return getCurrNode(index).e;
    }

    public void setFirst(E e) {
        set(0, e);
    }

    public void setLast(E e) {
        set(size - 1, e);
    }

    public void set(int index, E e) {
        getCurrNode(index).e = e;
    }

    public boolean contains(E e) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.e.equals(e)) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index Is Invalided");
        }
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalArgumentException("LinkedList Is Empty");
        }
    }

    private Node getPreNode(int index) {
        Node preNode = head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        return preNode;
    }

    private Node getCurrNode(int index) {
        checkIndex(index);
        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList: size = %d\n", size));
        Node curr = head;
        for (int i = 0; i < size; i++) {
            sb.append(curr.e).append("-->");
            curr = curr.next;
            if (i == size - 1) {
                sb.append("NULL");
            }
        }
        return sb.toString();
    }
}
