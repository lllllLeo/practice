package me.yujun.dequeue;

import java.util.*;

public class DequeueTest {

    public static void main(String[] args) {

//    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//    arrayDeque.add(1);
//    arrayDeque.add(2);
//    arrayDeque.add(3);
//    arrayDeque.add(4);
//
////    System.out.println(arrayDeque.peek());
//
//    for (int i = 0; i < arrayDeque.size(); i++) {
//        System.out.println(arrayDeque.peekLast());
//    }


    List<Integer> list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    System.out.println(list.toString());

    Collections.reverse(list);
    System.out.println(list);

    Collections.reverse(list);
    System.out.println(list);



    }
}
