package com.bigblue.book;

/**
 * @Author: TheBigBlue
 * @Description: 第二章的一个小例子
 * @Date: 2019/10/15
 */
public class SimpleAlgorithm {

    /**
     * 一个1+2+3+...+100的累加算法
     */
    public static void main(String[] args) {
        int count = 10000;
        commonThought(count);
        gaussianThought(count);
    }

    /**
     * 普通人的做法
     * @param count
     */
    private static void commonThought(int count) {
        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = 0; i <= count; i++) {
            sum += i;
        }
        System.out.println(sum + "\t" + (System.nanoTime() - startTime));
    }

    /**
     * 高斯的做法
     * @param count
     */
    private static void gaussianThought(int count) {
        long startTime = System.nanoTime();
        int sum = (1 + count) * count / 2;
        System.out.println(sum + "\t" + (System.nanoTime() - startTime));
    }

}
