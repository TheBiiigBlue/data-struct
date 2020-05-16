package com.bigblue.video.chapter5_linkedlist_recursion;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/11/12
 */
public class RecursionLinkedList {

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

        ListNode(int[] arr) {
            if (arr != null && arr.length > 0) {
                this.val = arr[0];
                ListNode curr = this;
                for (int i = 1; i < arr.length; i++) {
                    curr.next = new ListNode(arr[i]);
                    curr = curr.next;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode curr = this;
            while(curr != null){
                sb.append(curr.val).append("-->");
                curr = curr.next;
            }
            sb.append("NULL");
            return sb.toString();
        }
    }


    public ListNode removeElements(ListNode node, int value) {
        if(node == null){
            return null;
        }
        node.next = removeElements(node.next, value);
        return node.val == value ? node.next : node;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,5,6};
        ListNode listNode = new RecursionLinkedList().removeElements(new ListNode(arr), 6);
        System.out.println(listNode);
    }
}
