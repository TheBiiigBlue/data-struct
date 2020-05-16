package com.bigblue.video.chapter6_binary_search_tree;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/20
 */
public class BSTTest {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(3);
        System.out.println(bst.getSize());
    }
}
