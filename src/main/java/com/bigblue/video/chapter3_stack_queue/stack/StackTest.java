package com.bigblue.video.chapter3_stack_queue.stack;

import com.bigblue.video.chapter4_linkedlist.C_LinkedListStack;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public class StackTest {

    public static void main(String[] args) {
//        testArrayStack();
        testCompare();
    }

    private static void testArrayStack() {
        MyStack<Integer> stack = new MyArrayStack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }

    private static void testCompare() {
        MyArrayStack<Integer> arrayStack = new MyArrayStack<Integer>();
        System.out.println("ArrayStack Push Time: " + testPush(arrayStack));
        System.out.println("ArrayStack Pop Time: " + testPop(arrayStack));

        System.out.println();

        C_LinkedListStack<Integer> linkedListStack = new C_LinkedListStack<Integer>();
        System.out.println("LinkedListStack Push Time: " + testPush(linkedListStack));
        System.out.println("LinkedListStack Pop Time: " + testPop(linkedListStack));


    }

    private static long testPush(MyStack<Integer> stack) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stack.push(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long testPop(MyStack<Integer> stack) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stack.pop();
        }
        return System.currentTimeMillis() - start;
    }
}
