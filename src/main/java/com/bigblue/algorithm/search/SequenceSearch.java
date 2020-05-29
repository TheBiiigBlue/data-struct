package com.bigblue.algorithm.search;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2020/5/29
 */
public class SequenceSearch {

    /**
     * 顺序查找也称为线形查找，属于无序查找算法。从数据结构线形表的一端开始，顺序扫描，
     * 依次将扫描到的结点关键字与给定值k相比较，若相等则表示查找成功；
     * 若扫描结束仍没有找到关键字等于k的结点，表示查找失败。。
     *
     * 时间复杂度：
     *  查找成功时的平均查找长度为：（假设每个数据元素的概率相等） ASL = 1/n(1+2+3+…+n) = (n+1)/2
     *  当查找不成功时，需要n+1次比较，时间复杂度为O(n); 所以，**顺序查找的时间复杂度为O(n)**。
     */

    public static void main(String[] args) {
        int[] dataArr = {3, 4, 5, 1, 6, 2};
        int index = sequenceSearch(dataArr, 5);
        System.out.println("index: " + index);
    }

    private static int sequenceSearch(int[] dataArr, int value) {
        for (int i = 0; i < dataArr.length; i++) {
            if (dataArr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
