package com.bigblue.video.chapter3_stack_queue.queue;

import com.bigblue.video.chapter4_linkedlist.D_LinkedListQueue;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/24
 */
public class QueueTest {

    public static void main(String[] args) {
//        testQueue();
        testCompare();
    }

    private static void testQueue() {
//        MyQueue<Integer> queue = new MyArrayQueue<Integer>();
        MyQueue<Integer> queue = new D_LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue);
            System.out.println("front: " + queue.getFront());
        }

//        System.out.println("====================================");
//
//        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<Integer>();
//        for (int i = 0; i < 11; i++) {
//            loopQueue.enqueue(i);
//        }
//        System.out.println(loopQueue);
//
//        for (int i = 0; i < 6; i++) {
//            loopQueue.dequeue();
//        }
//        System.out.println(loopQueue);
    }

    private static void testCompare() {
        MyQueue<Integer> loopQueue = new MyLoopQueue<Integer>();
        System.out.println("LoopQueue Enqueue Time: " + testEnqueue(loopQueue));
        System.out.println("LoopQueue Dequeue Time: " + testDequeue(loopQueue));

        System.out.println();

        MyQueue<Integer> linkedListQueue = new D_LinkedListQueue<Integer>();
        System.out.println("LinkedListQueue Enqueue Time: " + testEnqueue(linkedListQueue));
        System.out.println("LinkedListQueue Dequeue Time: " + testDequeue(linkedListQueue));

        System.out.println();

        MyQueue<Integer> arrayQueue = new MyArrayQueue<Integer>();
        System.out.println("ArrayQueue Enqueue Time: " + testEnqueue(arrayQueue));
        System.out.println("ArrayQueue Dequeue Time: " + testDequeue(arrayQueue));
    }

    private static long testEnqueue(MyQueue<Integer> queue) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            queue.enqueue(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long testDequeue(MyQueue<Integer> queue) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            queue.dequeue();
        }
        return System.currentTimeMillis() - start;
    }
}
