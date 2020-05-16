package com.bigblue.leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/12
 */
public class Problem771 {

    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     * 示例1：
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     *
     * 示例2：
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     */

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char c : S.toCharArray()) {
            if(J.indexOf(c) > -1){
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones1(String J, String S) {
        int count = 0;
        Set<Character> characters = new HashSet<Character>();
        for(char c : J.toCharArray()){
            characters.add(c);
        }
        for(char c : S.toCharArray()) {
            if(characters.contains(c)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problem771().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new Problem771().numJewelsInStones1("z", "ZZ"));
    }
}
