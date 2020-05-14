package com.lyj.structure;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: 带头部的单链表
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
//进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.addHero(hero1);
        singleLinkedList.addHero(hero4);
        singleLinkedList.addHero(hero2);
        singleLinkedList.addHero(hero3);

        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();

        //创建要给链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        System.out.println("按排名顺序加入数据~~");
        //加入
        singleLinkedList1.addHeroByOrder(hero1);
        singleLinkedList1.addHeroByOrder(hero4);
        singleLinkedList1.addHeroByOrder(hero2);
        singleLinkedList1.addHeroByOrder(hero3);
        singleLinkedList1.list();
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                //", next=" + next +
                '}';
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

}

class SingleLinkedList{
    private HeroNode head=new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }
    //增加
    public void addHero(HeroNode hero){
        HeroNode tmp=head;
        while(true){
            if(tmp.next == null){
                break;
            }
            tmp=tmp.next;
        }
        tmp.next=hero;
    }

    //输出列表
    public void list(){
        if(head.next == null){
            System.out.printf("链表为空！");
            return;
        }
        HeroNode tmp=head;
        while(true){
            if(tmp.next == null){
                System.out.println("链表输出完毕！");
                return;
            }
            System.out.println(tmp.next);
            tmp=tmp.next;
        }
    }

    //逆序
    //按照排名添加数据;(如果有这个排名，则添加失败，并给出提示)
    public void addHeroByOrder(HeroNode hero){
        HeroNode tmp=head;
        boolean isExsit=false;
        while(true){
            //已经到链表结尾
            if(tmp.next == null){
                break;
            }
            if(tmp.next.no > hero.no){ //找到位置
                break;
            }else if(hero.no ==tmp.next.no){
                isExsit=true;
                break;
            }
            tmp=tmp.next;
        }
        if(isExsit){
            System.out.println("已存在相同排名的英雄：%d"+tmp.no);
        }else{
            //将数据插入
            hero.next=tmp.next;
            tmp.next=hero;
        }
    }
}
