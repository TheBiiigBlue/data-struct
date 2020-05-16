package com.bigblue.leetcode.simple;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/6
 */
public class Problem_LCP1 {

    /**
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     * 链接：https://leetcode-cn.com/problems/guess-numbers
     */

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if(guess[i] == answer[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] guess = {1,2,3};
        int[] answer = {2,2,3};
        System.out.println(new Problem_LCP1().game(guess, answer));
    }
}
