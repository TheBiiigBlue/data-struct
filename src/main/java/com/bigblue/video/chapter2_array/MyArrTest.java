package com.bigblue.video.chapter2_array;

/**
 * @Author: TheBigBlue
 * @Description:
 * @Date: 2019/10/22
 */
public class MyArrTest {

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        for (int i = 0; i < 10; i++) {
            myArray.addLast(i);
        }
        System.out.println(myArray);

        myArray.add(1, 100);
        System.out.println(myArray);

        myArray.addFirst(-1);
        System.out.println(myArray);

        System.out.println(myArray.find(5));
        System.out.println(myArray.contains(10));
        System.out.println(myArray.isEmpty());

        myArray.removeElement(100);
        System.out.println(myArray);

        myArray.removeFirst();
        System.out.println(myArray);

        myArray.removeLast();
        System.out.println(myArray);

        myArray.remove(5);
        System.out.println(myArray);

        myArray.remove(1);
        System.out.println(myArray);

        myArray.remove(2);
        System.out.println(myArray);

        myArray.removeFirst();
        System.out.println(myArray);
    }

}
