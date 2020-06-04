package com.bigblue.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description: 归并排序
 * @Date: 2020/6/4
 */
public class MergeSort {

    /**
     * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，
     * 因为始终都是O(nlogn)的时间复杂度。代价是需要额外的内存空间。
     * <p>
     * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；
     * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
     * <p>
     * 因为归并排序需要创建额外内存，所以小数据量效率不如快排
     * 但是当数据量达到亿级以上，归并的优势就显现出来了，因为归并的最差时间复杂度也是nlogn,而快排最差是n^2
     * <p>
     * 平均时间复杂度：O(nlogn)
     * 最优时间复杂度：O(n)
     * 最差时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     */

    public static void main(String[] args) {
        int[] dataArr = {3, 4, 5, 1, 6, 2};
        //辅助数组
        int[] tmp = new int[dataArr.length];
        mergeSort(dataArr, 0, dataArr.length - 1, tmp);
        System.out.println(Arrays.toString(dataArr));
    }

    public static void mergeSort(int[] dataArr, int left, int right, int[] tmp) {
        //当子序列中只有一个元素时结束递归
        if (left < right) {
            //划分子序列
            int mid = left + (right - right) / 2;
            //对左侧子序列进行递归排序
            mergeSort(dataArr, left, mid, tmp);
            //对右侧子序列进行递归排序
            mergeSort(dataArr, mid + 1, right, tmp);
            //合并
            merge(dataArr, left, mid, right, tmp);
        }
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int[] dataArr, int left, int mid, int right, int[] tmp) {
        //p1、p2是检测指针，k是存放指针
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            tmp[k++] = dataArr[p1] < dataArr[p2] ? dataArr[p1++] : dataArr[p2++];
        }
        //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p1 <= mid) tmp[k++] = dataArr[p1++];
        //同上
        while (p2 <= right) tmp[k++] = dataArr[p2++];
        //复制回原素组
        for (int i = left; i <= right; i++) {
            dataArr[i] = tmp[i];
        }
    }
}
