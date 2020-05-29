package com.bigblue.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description: 冒泡排序
 * @Date: 2020/5/16
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] dataArr = {3, 2, 1, 5, 6, 0, -1, 7, 4};
        bubbleSort(dataArr);
        System.out.println(Arrays.toString(dataArr));
    }

    /**
     * 相邻两个元素，两两比较
     * 平均时间复杂度：O(n^2)
     * 最优时间复杂度：O(n)
     * 最差时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param dataArr
     */
    private static void bubbleSort(int[] dataArr) {
        for (int i = 0; i < dataArr.length - 1; i++) {
            //是否有序标识，如果当轮后，已经有序，则后续不再排序，直接退出
            boolean orderedFlag = false;
            for (int j = 0; j < dataArr.length - i - 1; j++) {
                if (dataArr[j] > dataArr[j + 1]) {
                    int temp = dataArr[j];
                    dataArr[j] = dataArr[j + 1];
                    dataArr[j + 1] = temp;
                    orderedFlag = true;
                }
            }
            if (!orderedFlag) {
                break;
            }
        }
    }
}
