package com.yh.linkedlist.dou;

/**
 * 每个HeroNode就是一个节点
 */
class HeroNode2 {

    public int no;
    public String nickName;
    public String name;
    public HeroNode2 next;
    public HeroNode2 pre;


    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
