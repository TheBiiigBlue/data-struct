package com.bigblue.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description: 选择排序
 * @Date: 2020/6/1
 */
public class SelectionSort {

    /**
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     *      然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
     * 唯一的好处可能就是不占用额外的内存空间了吧。
     *
     * 时间复杂度：
     *      最优：O(n^2)
     *      最差：O(n^2)
     *      平均：O(n^2)
     * 空间复杂度：
     *      O(1)
     * 稳定性：不稳定
     *
     * 二元选择排序：
     *    选择一个当前位置i，从开始到序列一半位置。每次遍历产生一个最大值，一个最小值。
     *    将产生的最小值和最大值分别与当前位置i和序列长度-i上的元素交换
     *  时间复杂度： O(n^2) 但是比普通选择排序快一倍
     */

    public static void main(String[] args) {
        int[] dataArr = {3,4,5,1,6,2};
        simpleSelectionSort(dataArr);
        binarySelectionSort(dataArr);
        System.out.println(Arrays.toString(dataArr));
    }

    /**
      * @Author: TheBigBlue
      * @Description: 普通的选择排序
      * @Date: 2020/6/1
      * @Param:
      * @return:
      **/
    private static void simpleSelectionSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            for (int i = 0; i < dataArr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < dataArr.length; j++) {
                    if (dataArr[j] < dataArr[min]){
                        min = j;
                    }
                }
                if(min != i) {
                    int temp = dataArr[i];
                    dataArr[i] = dataArr[min];
                    dataArr[min] = temp;
                }
            }
        }
    }

    /**
      * @Author: TheBigBlue
      * @Description: 优化的选择排序：二元选择排序
      * @Date: 2020/6/1
      * @Param:
      * @return:
      **/
    private static void binarySelectionSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            for (int i = 0; i <= dataArr.length/2; i++) {
                int min = i;
                int max = i;
                //循环一轮，找出最小值
                for (int j = i + 1; j < dataArr.length - i; j++) {
                    if(dataArr[min] > dataArr[j]){
                        min = j;
                        continue;
                    }
                    if (dataArr[j] > dataArr[max]) {
                        max = j;
                    }
                }
                //将当前值和最小值交换
                if(min != i){
                    int temp = dataArr[i];
                    dataArr[i] = dataArr[min];
                    dataArr[min] = temp;
                }
                //将当前循环的最后一个位置和最大索引所在位置交换
                if (max != i) {
                    int temp = dataArr[dataArr.length - 1 - i];
                    dataArr[dataArr.length - 1 - i] = dataArr[max];
                    dataArr[max] = temp;
                }
            }
        }
    }
}
