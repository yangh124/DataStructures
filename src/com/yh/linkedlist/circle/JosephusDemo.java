package com.yh.linkedlist.circle;

/**
 * @author : yh
 * @date : 2021/3/20 20:55
 */
public class JosephusDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.list();
        circleSingleLinkedList.countBoy(1, 2, 10);
    }
}
