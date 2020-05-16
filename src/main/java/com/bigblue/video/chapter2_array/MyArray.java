package com.bigblue.video.chapter2_array;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/22
 */
public class MyArray<E> {

    private E[] data;

    private int size;

    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyArray() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E[] getData() {
        return data;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Add Failed");
        }
        if (size == data.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Faileds");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set Faileds");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        return find(e) != -1;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("Remove Failed");
        }
        E retValue = data[i];
        for (int j = i + 1; j < size; j++) {
            data[j - 1] = data[j];
        }
        size--;
        if (size == data.length / 4 && size != 0) {
            resize(data.length / 2);
        }
        return retValue;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] elements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            elements[i] = data[i];
        }
        data = elements;
    }
}

