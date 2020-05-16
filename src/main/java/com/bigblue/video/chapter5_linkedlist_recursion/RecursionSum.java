package com.bigblue.video.chapter5_linkedlist_recursion;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/6
 */
public class RecursionSum {

    /**
     * 计算arr[1,2,3,4,...100]之和
     */

    public static int sum(int[] arr) {
        return recursionSum(arr, 0);
    }

    private static int recursionSum(int[] arr, int index) {
        if(index == arr.length){
            return 0;
        }
        return arr[index] + recursionSum(arr, index + 1);
    }

    public static int sum1(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println("sum: " + sum1(arr));
    }
}
