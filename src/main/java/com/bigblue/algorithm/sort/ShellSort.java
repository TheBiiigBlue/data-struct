package com.bigblue.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description: 希尔排序
 * @Date: 2020/6/3
 */
public class ShellSort {

    /**
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一
     * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     *      待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     *
     *  希尔排序是基于插入排序的以下两点性质而提出改进方法的：
     *      插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
     *      但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
     *
     *  平均时间复杂度：nlogn
     *  最优时间复杂度：nlogn
     *  最差时间复杂度：O(n^2)
     *  空间复杂度： O(1)
     *  稳定性： 不稳定
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] dataArr = {3,4,5,1,6,2};
        shellSort(dataArr);
        System.out.println(Arrays.toString(dataArr));
    }

    private static void shellSort(int[] dataArr) {
        int len = dataArr.length;
        int currEle, preIndex, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                currEle = dataArr[i];
                preIndex = i - gap;
                while (preIndex >= 0 && dataArr[preIndex] > currEle) {
                    dataArr[preIndex + gap] = dataArr[preIndex];
                    preIndex -= gap;
                }
                dataArr[preIndex + gap] = currEle;
            }
            gap /= 2;
        }
    }
}
