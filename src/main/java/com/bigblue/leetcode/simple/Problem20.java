package com.bigblue.leetcode.simple;

import java.util.Stack;

/**
 * @Author: TheBigBlue
 * @Description: 括号匹配
 * @Date: 2019/10/24
 */
public class Problem20 {

    /**
     * 栈实现
     */

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
//            MyArrayStack<Character> stack = new MyArrayStack();
            for(Character c : s.toCharArray()){
                if(c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                }else {
                    Character ele = stack.pop();
                    if((c == ')' && ele != '(')
                            || (c == ']' && ele != '[')
                            || (c == '}' && ele != '{')){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([{}])"));
        System.out.println(new Solution().isValid("([{})"));
        System.out.println(new Solution().isValid("([{})]"));
        System.out.println(new Solution().isValid("})]"));
    }
}
