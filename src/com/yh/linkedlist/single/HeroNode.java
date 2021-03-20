package com.yh.linkedlist.single;

/**
 * 每个HeroNode就是一个节点
 */
class HeroNode {

    public int no;

    public String nickName;

    public String name;

    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
