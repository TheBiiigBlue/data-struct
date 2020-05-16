package com.bigblue.video.chapter6_binary_search_tree;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/20
 */
public class BinarySearchTree<E extends Comparable<E>> {

    public class Node {
        private E e;
        private Node left, right;

        public Node() {
            e = null;
            left = right = null;
        }

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    /**
     * 麻烦一点的递归
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node root, E e) {
        if (e.equals(root.e)) {
            return;
        } else if (e.compareTo(root.e) > 0 && root.right == null) {
            root.right = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(root.e) > 0) {
            add(root.right, e);
        } else if (e.compareTo(root.e) < 0) {
            add(root.left, e);
    }
    */

    /**
     * 简化递归
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

}
