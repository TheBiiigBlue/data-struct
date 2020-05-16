package com.bigblue.video.chapter4_linkedlist;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/30
 */
public class B_DummyHeadLinkedList<E> {

    /**
     * 有虚拟头结点的LinkedList，比LinkedList的处理更平滑了，
     * 主要是不用做头结点特殊处理了，但还是存在问题
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

    private Node dummyHead;
    private int size;

    public B_DummyHeadLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return this.size;
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
        Node preNode = getPreNode(index);
        preNode.next = new Node(e, preNode.next);
        size++;
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
        Node preNode = getPreNode(index);
        Node delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public boolean contains(E e) {
        Node currNode = dummyHead.next;
        while (currNode != null) {
            if (currNode.e.equals(e)) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    private E get(int index) {
        checkIndex(index);
        return getCurrNode(index).e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    private void set(int index, E e) {
        checkIndex(index);
        getCurrNode(index).e = e;
    }

    public void setFirst(E e) {
        set(0, e);
    }

    public void setLast(E e) {
        set(size - 1, e);
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
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        return preNode;
    }

    private Node getCurrNode(int index) {
        Node currNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("DummyHeadLinkedList: size = %d\n", size));
//        sb.append(String.format("TOP\t"));
        Node curr = dummyHead.next;
        for (int i = 0; i < size; ++i) {
            sb.append(curr.e).append("-->");
            curr = curr.next;
            if (i == size - 1) {
                sb.append("NULL");
            }
        }
        return sb.toString();
    }
}
