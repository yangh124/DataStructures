package com.yh.linkedlist.dou;


/**
 * 双向链表
 *
 * @author : yh
 * @date : 2021/3/20 18:14
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();
        System.out.println("=================================================");
        //修改
        HeroNode2 heroNode5 = new HeroNode2(4, "杨皓", "大帅哥");
        doubleLinkedList.updateByNo(heroNode5);
        doubleLinkedList.list();
        System.out.println("=================================================");
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        doubleLinkedList1.addByOrder(heroNode2);
        doubleLinkedList1.addByOrder(heroNode1);
        doubleLinkedList1.addByOrder(heroNode4);
        doubleLinkedList1.addByOrder(heroNode3);
        doubleLinkedList1.list();
    }
}
