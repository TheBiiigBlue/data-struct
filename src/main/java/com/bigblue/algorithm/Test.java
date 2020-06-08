package com.bigblue.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2020/6/3
 */
public class Test {

    public static void main(String[] args) {
//        Random random = new Random();
//        int[] dataArr = new int[100000];
//        for (int i = 0; i < dataArr.length - 1; i++) {
//            dataArr[i] = random.nextInt(100000);
//        }

        int[] dataArr = {3, 1, 5, 2, 6, 4};

//        quickSort(dataArr, 0, dataArr.length - 1);
//        bubbleSort(dataArr);
//        selectionSort(dataArr);
//        binarySelectionSort(dataArr);
//        insertionSort(dataArr);
//        shellSort(dataArr);
        int[] temp = new int[dataArr.length];
        mergeSort(dataArr, 0, dataArr.length - 1, temp);

        System.out.println(Arrays.toString(dataArr));
//        System.out.println("index6: " + binarySearch(dataArr, 6));
//        System.out.println("index1: " + recursionBinarySearch(dataArr, 0, dataArr.length - 1, 1));
    }

    /**
     * avg: logn
     * optimal: logn
     * worst: logn
     * space: O(n)
     * 稳定
     */
    private static void mergeSort(int[] dataArr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(dataArr, left, mid, temp);
            mergeSort(dataArr, mid + 1, right , temp);
            merge(dataArr, left, mid, right, temp);
        }
    }

    private static void merge(int[] dataArr, int left, int mid, int right, int[] temp) {
        int p1 = left, p2 = mid + 1, index = left;
        while (p1 <= mid && p2 <= right) {
            temp[index++] = dataArr[p1] < dataArr[p2] ? dataArr[p1++] : dataArr[p2++];
        }
        while (p1 <= mid) {
            temp[index++] = dataArr[p1++];
        }
        while (p2 <= right) {
            temp[index++] = dataArr[p2++];
        }
        for (int i = left; i <= right; i++) {
            dataArr[i] = temp[i];
        }
    }

    /**
     * avg: nlogn
     * optimal: nlogn
     * worst: n^2
     * space: O(1)
     * 不稳定
     * @param dataArr
     */
    private static void shellSort(int[] dataArr) {
        int len = dataArr.length;
        int preIndex, currEle, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                currEle = dataArr[i];
                preIndex = i - gap;
                while (preIndex >= 0 && currEle < dataArr[preIndex]) {
                    dataArr[preIndex + gap] = dataArr[preIndex];
                    preIndex -= gap;
                }
                dataArr[preIndex + gap] = currEle;
            }
            gap /= 2;
        }
    }

    /**
     * avg: n^2
     * optimal: n
     * worst: n^2
     * space: O(1)
     * 稳定
     * @param dataArr
     */
    private static void insertionSort(int[] dataArr) {
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

    /**
     * avg: n^2
     * optimal: n^2
     * worst: n^2
     * space: O(1)
     * 不稳定
     * @param dataArr
     */
    private static void binarySelectionSort(int[] dataArr) {
        for (int i = 0; i < dataArr.length / 2; i++) {
            int min = i;
            int max = i;
            for (int j = i + 1; j < dataArr.length - i; j++) {
                if (dataArr[min] > dataArr[j]) {
                    min = j;
                    continue;
                }
                if (dataArr[max] < dataArr[j]) {
                    max = j;
                }
            }
            if (min != i) {
                int temp = dataArr[i];
                dataArr[i] = dataArr[min];
                dataArr[min] = temp;
            }
            if (max != i) {
                int temp = dataArr[dataArr.length - i - 1];
                dataArr[dataArr.length - i - 1] = dataArr[max];
                dataArr[max] = temp;
            }
        }
    }

    /**
     * avg: n^2
     * optimal: n^2
     * worst: n^2
     * space: O(1)
     * 不稳定
     * @param dataArr
     */
    private static void selectionSort(int[] dataArr) {
        for (int i = 0; i < dataArr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < dataArr.length; j++) {
                if (dataArr[min] > dataArr[j]){
                    min = j;
                }
            }
            if (min != i) {
                int temp = dataArr[i];
                dataArr[i] = dataArr[min];
                dataArr[min] = temp;
            }
        }
    }

    /**
     * avg: n^2
     * optimal: n
     * worst: n^2
     * space: O(1)
     * 稳定
     * @param dataArr
     */
    private static void bubbleSort(int[] dataArr) {
        for (int i = 0; i < dataArr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < dataArr.length - 1 - i; j++) {
                if (dataArr[j] > dataArr[j + 1]){
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

    /**
     * 最优：nlogn
     * 最差：n^2
     * 平均：nlogn
     * 空间：nlogn
     * 不稳定
     */
    private static void quickSort(int[] dataArr, int left, int right) {
        if (left > right) {
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
