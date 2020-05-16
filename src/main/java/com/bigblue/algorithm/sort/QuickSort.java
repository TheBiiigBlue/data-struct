package com.bigblue.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2020/5/10
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] dataArr = {3,4,5,1,6,2};
        quickSort(dataArr, 0, dataArr.length - 1);
        System.out.println(Arrays.toString(dataArr));
    }

    /**
     * 先从数列中取出一个数作为基准数。
     * 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 再对左右区间重复第二步，直到各区间只有一个数。
     *
     * 平均时间复杂度：O(nlogn)
     * 最优时间复杂度：O(nlogn)
     * 最差时间复杂度：O(n^2)
     * 空间复杂度：O(nlogn)
     * 稳定性：不稳定
     * @param dataArr
     */
    private static void quickSort(int[] dataArr, int left, int right) {
        if(left >= right){
            return;
        }
        //设置最左边的元素为基准值
        int key = dataArr[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while(i < j) {
            //j向左移，直到遇到比key小的值
            while (dataArr[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(dataArr[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            int temp = dataArr[i];
            dataArr[i] = dataArr[j];
            dataArr[j] = temp;
        }
        //key值归位
        dataArr[left] = dataArr[i];
        dataArr[i] = key;
        //重新排序左侧
        quickSort(dataArr, left, i - 1);
        //重新排序右侧
        quickSort(dataArr, i + 1, right);
    }
}
