package com.bigblue.video.chapter4_linkedlist;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/30
 */
public class Z_LinkedListTest {

    public static void main(String[] args) {
//        testLinkedList();

        testLinkedListStack();
    }

    private static void testLinkedList() {
        A_LinkedList<Integer> linkedList = new A_LinkedList<Integer>();
//        B_DummyHeadLinkedList<Integer> linkedList = new B_DummyHeadLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        linkedList.addLast(10);
        System.out.println(linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println("get last: " + linkedList.getLast());
        linkedList.setLast(100);
        System.out.println("set last 100");
        System.out.println(linkedList);

        System.out.println("contains 90:" + linkedList.contains(90));
    }

    private static void testLinkedListStack() {
        C_LinkedListStack<Integer> linkedListStack = new C_LinkedListStack<Integer>();
        for (int i=0;i<10;i++) {
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack);
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }
}
