package com.bigblue.leetcode.simple;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/6
 */
public class Problem203 {

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    /**
     * @Author: TheBigBlue
     * @Description: 递归
     * @Date: 2019/11/6
     **/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

//        ListNode node = removeElements(head.next, val);
//        if (head.val != val) {
//            head.next = node;
//            node = head;
//        }
//        return node;
    }

    /**
     * @Author: TheBigBlue
     * @Description: 虚拟头结点，不递归
     * @Date: 2019/11/6
     * @Param head:
     * @Param val:
     * @Return:
     **/
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode(-1, null);
        for (int i = 6; i > 0; i--) {
            dummyHead.next = new ListNode(i, dummyHead.next);
        }
        dummyHead.next = new ListNode(6, dummyHead.next);
        printListNode(dummyHead.next);
        printListNode(new Problem203().removeElements(dummyHead.next, 6));
    }

    public static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val).append("-->");
            curr = curr.next;
        }
        sb.append("NULL");
        System.out.println(sb);
    }
}
