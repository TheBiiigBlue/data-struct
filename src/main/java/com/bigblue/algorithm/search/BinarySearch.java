package com.bigblue.algorithm.search;

import com.bigblue.algorithm.sort.QuickSort;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description: 二分查找法
 * @Date: 2020/5/29
 */
public class BinarySearch {


    /**
     * 二分查找：
     *  有序的序列，每次都是以序列的中间位置的数来与待查找的关键字进行比较，每次缩小一半的查找范围，直到匹配成功。
     *  一个情景：将表中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功；否则利用中间位置记录将表分成前、后两个子表，
     *      如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，否则进一步查找后一子表。重复以上过程，直到找到满足条件的记录，
     *      使查找成功，或直到子表不存在为止，此时查找不成功。
     *  优点：
     *     比较次数少，查找快，平均性能好
     *  缺点：
     *      要求待查表有序，且插入删除困难
     *  因此：适用于不经常变动的、查找频繁的、有序的的结构
     *
     *  时间复杂度：
     *      最优：O(1)
     *      最差：O(logn)
     *      平均：O(logn)
     *  空间复杂度：
     *      循环方式：因为循环中无变量，所以为O(1)
     *      递归方式：递归的深度为O(logn)，每个深度是常亮的，所以为O(logn)
     *
     */

    public static void main(String[] args) {
        int[] dataArr = {3, 4, 5, 1, 6, 2};
        QuickSort.quickSort(dataArr, 0, dataArr.length - 1);
        System.out.println(Arrays.toString(dataArr));

        int index1 = binarySearch(dataArr, 1);
        System.out.println("index1: " + index1);
        int index2 = recursionBinarySearch(dataArr, 0, dataArr.length - 1, 6);
        System.out.println("index2: " + index2);
    }

    /**
     * @Author: TheBigBlue
     * @Description: 循环方式
     * @Date: 2020/5/29
     * @Param:
     * @return:
     **/
    public static int binarySearch(int[] dataArr, int value) {
        int left = 0;
        int right = dataArr.length - 1;
        //只定义一次
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (dataArr[mid] == value) {
                return mid;
            } else if (dataArr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @Author: TheBigBlue
     * @Description: 递归方式
     * @Date: 2020/5/29
     * @Param:
     * @return:
     **/
    public static int recursionBinarySearch(int[] dataArr, int left, int right, int value) {
        if(left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(dataArr[mid] == value){
            return mid;
        }else if(dataArr[mid] > value) {
            return recursionBinarySearch(dataArr, left, mid - 1, value);
        }else {
            return recursionBinarySearch(dataArr, mid + 1, right, value);
        }
    }
}
