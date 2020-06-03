package com.bigblue.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description: 插入排序
 * @Date: 2020/6/1
 */
public class InsertionSort {

    /**
     * 插入排序（Insertion-Sort）通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，
     *  找到相应位置并插入。在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
     *
     *  步骤：
     *      从第一个元素开始，该元素可以认为已经被排序；
     *      取出下一个元素，在已经排序的元素序列中从后向前扫描；
     *      如果该元素（已排序）大于新元素，将该元素移到下一位置；
     *      重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *      将新元素插入到该位置后；
     *      重复步骤2~5。
     *
     *  平均时间复杂度：O(n^2)
     *  最优时间复杂度：O(n)
     *  最坏时间复杂度：O(n^2)
     *  空间复杂度：O(1)
     *  稳定性：稳定
     */

    public static void main(String[] args) {
        int[] dataArr = {3,4,5,1,6,2};
        insertionSort(dataArr);
        System.out.println(Arrays.toString(dataArr));
    }

    private static void insertionSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            int currEle, preIndex;
            for (int i = 0; i < dataArr.length - 1; i++) {
                currEle = dataArr[i + 1];
                preIndex = i;
                //从后往前比，找到比当前元素小的，咋插入小元素后面
                while (preIndex >= 0 && currEle < dataArr[preIndex]) {
                    dataArr[preIndex + 1] = dataArr[preIndex];
                    preIndex--;
                }
                dataArr[preIndex + 1] = currEle;
            }
        }
    }
}
