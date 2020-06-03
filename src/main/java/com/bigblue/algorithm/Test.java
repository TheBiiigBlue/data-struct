package com.bigblue.algorithm;

import java.util.Arrays;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2020/6/3
 */
public class Test {

    public static void main(String[] args) {
        int[] dataArr = {3, 1, 5, 2, 6, 4};
//        quickSort(dataArr, 0, dataArr.length - 1);
//        bubbleSort(dataArr);
//        selectionSort(dataArr);
//        binarySelectionSort(dataArr);
        insertionSort(dataArr);
        System.out.println(Arrays.toString(dataArr));
        System.out.println("index6: " + binarySearch(dataArr, 6));
        System.out.println("index1: " + recursionBinarySearch(dataArr, 0, dataArr.length - 1, 1));
    }

    private static int recursionBinarySearch(int[] dataArr, int left, int right, int value) {
        if (dataArr == null || dataArr.length == 0 || left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(dataArr[mid] == value) {
            return mid;
        }else if (dataArr[mid] > value) {
            return recursionBinarySearch(dataArr, left, mid - 1, value);
        }else {
            return recursionBinarySearch(dataArr, mid + 1, right, value);
        }
    }

    private static int binarySearch(int[] dataArr, int value) {
        if(dataArr == null || dataArr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = dataArr.length - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(dataArr[mid] == value) {
                return mid;
            }else if(dataArr[mid] > value) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * time: n^2
     * space: O(n)
     * stability: stable
     */
    private static void insertionSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            int currEle, preIndex;
            for (int i = 0; i < dataArr.length - 1; i++) {
                currEle = dataArr[i + 1];
                preIndex = i;
                while (preIndex >= 0 && currEle < dataArr[preIndex]) {
                    dataArr[preIndex + 1] = dataArr[preIndex];
                    preIndex--;
                }
                dataArr[preIndex + 1] = currEle;
            }
        }
    }

    /**
     * time: n^2
     * space: O(1)
     * stability: unstable
     */
    private static void binarySelectionSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            for (int i = 0; i < dataArr.length / 2; i++) {
                int min = i, max = i;
                for (int j = i + 1; j < dataArr.length - i; j++) {
                    if(dataArr[j] < dataArr[min]){
                        min = j;
                        continue;
                    }
                    if (dataArr[j] > dataArr[max]) {
                        max = j;
                    }
                }
                if(min != i) {
                    int temp = dataArr[i];
                    dataArr[i] = dataArr[min];
                    dataArr[min] = temp;
                }
                if(max != i) {
                    int temp = dataArr[dataArr.length - i - 1];
                    dataArr[dataArr.length - i - 1] = dataArr[max];
                    dataArr[max] = temp;
                }
            }
        }
    }

    /**
     * time: n^2
     * space: O(1)
     * stability: unstable
     */
    private static void selectionSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            for (int i = 0; i < dataArr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < dataArr.length; j++) {
                    if(dataArr[j] < dataArr[min]){
                        min = j;
                    }
                }
                int temp = dataArr[i];
                dataArr[i] = dataArr[min];
                dataArr[min] = temp;
            }
        }
    }

    /**
     * time: n^2
     * space: O(1)
     * stability: stable
     */
    private static void bubbleSort(int[] dataArr) {
        if (dataArr != null && dataArr.length > 0) {
            for (int i = 0; i < dataArr.length - 1; i++) {
                boolean flag = false;
                for (int j = 0; j < dataArr.length - 1 - i; j++) {
                    if (dataArr[j] > dataArr[j + 1]) {
                        int temp = dataArr[j];
                        dataArr[j] = dataArr[j + 1];
                        dataArr[j + 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
            }
        }
    }

    /**
     * time: nlogn
     * space: logn
     * stability: unstable
     */
    private static void quickSort(int[] dataArr, int left, int right) {
        if (left > right || dataArr == null || dataArr.length == 0) {
            return;
        }
        int key = dataArr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (dataArr[j] >= key && i < j) {
                j--;
            }
            while (dataArr[i] <= key && i < j) {
                i++;
            }
            int temp = dataArr[i];
            dataArr[i] = dataArr[j];
            dataArr[j] = temp;
        }
        dataArr[left] = dataArr[i];
        dataArr[i] = key;
        quickSort(dataArr, left, i - 1);
        quickSort(dataArr, i + 1, right);
    }
}
