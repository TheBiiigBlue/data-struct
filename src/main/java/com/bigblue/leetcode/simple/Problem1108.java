package com.bigblue.leetcode.simple;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/12
 */
public class Problem1108 {

    /**
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     *
     * 示例1：
     * 输入：address = "1.1.1.1"
     * 输出："1[.]1[.]1[.]1"
     *
     * 示例2：
     * 输入：address = "255.100.50.0"
     * 输出："255[.]100[.]50[.]0"
     */

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr1(String address) {
        char[] chars = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == 46){
                sb.append("[.]");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1108 obj = new Problem1108();
        System.out.println(obj.defangIPaddr("1.1.1.1"));
        System.out.println(obj.defangIPaddr1("255.100.50.0"));
    }
}
