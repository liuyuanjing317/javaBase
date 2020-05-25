package com.lyj.structure;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

import java.util.Stack;

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
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();

 /*       // 测试一下单链表的反转功能
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
*/
        singleLinkedList.reversePrint(singleLinkedList.getHead());
       // System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
       // System.out.println(singleLinkedList.getDeSortNodeByNum(singleLinkedList.getHead(),1));
       // System.out.println(singleLinkedList.reverseLinkedList(singleLinkedList.getHead()));
       // System.out.println(singleLinkedList.reverseLinkedList(singleLinkedList.getHead()));

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

    public HeroNode() {
        super();
    }
}


class DoubleHeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode pre;
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                //", next=" + next +
                '}';
    }



    public DoubleHeroNode() {
        super();
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


    // 求单链表中有效节点的个数 获取单链表长度
    public  int getLength(HeroNode head) {
        int length = 0;
        HeroNode tmp = head;
        if(head.next == null){
            System.out.printf("链表为空！");
            return 0;
        }
        while (true) {
            if(tmp.next != null){
                length++;
                tmp=tmp.next;
            }else{
                break;
            }
        }
        return length;
    }

    // 查找单链表中的倒数第k个结点
    public  HeroNode getDeSortNodeByNum(HeroNode head,int index) {
        int length = getLength(head);
        if(length<=0){
            return null;
        }
        HeroNode tmp = head.next;
        HeroNode cur =  new HeroNode();
        if(length<index){
            return null;
        }
        for(int i=0;i<length-index;i++){
            cur=tmp.next;
            tmp=tmp.next;
        }
       return cur;
    }

    //单链表的反转
    public  HeroNode reverseLinkedList(HeroNode head) {
       //链表为空或只有一个节点直接返回
        if(head.next == null || head.next.next == null) {
            return null;
        }
        HeroNode cur=head.next;
        HeroNode next=new HeroNode();
        HeroNode reverse=new HeroNode();
        while (cur !=null){
            next=cur.next;
            cur.next=reverse.next;//
            reverse.next=next;
            cur=next;
        }
        head.next=reverse.next;
        return head;
    }


    //逆序打印 1.反序遍历，2 使用栈
    public  void reversePrint(HeroNode head) {
        Stack<HeroNode> stack=new Stack<HeroNode>();
        int length = getLength(head);
        for(int i=0;i<length;i++){
        stack.push(head.next);
        head=head.next;
        }
        //System.out.println(stack);
        for(int i=0;i<length;i++){
            System.out.println(stack.pop());
        }
    }


    //合并两个有序的单链表，合并之后的链表依然有序
    /*
    * 1. list 1,list2 ，从list1开始遍历，与list2进行对比，小的节点取出 进行放在新的结果集里。
    * */
    public HeroNode combaine(HeroNode A,HeroNode B){

        //链表为空或只有一个节点直接返回
        if(B.next == null || B.next.next == null) {
            return null;
        }
        //链表为空或只有一个节点直接返回
        if(A.next == null || A.next.next == null) {
            return null;
        }

        //结果集
        HeroNode res=new HeroNode();
        //放小的那个节点
        HeroNode pre=new HeroNode();
        //两个单链表的游标
        HeroNode cur1=A.next;
        HeroNode cur2=B.next;
        HeroNode next =null;
        while(cur1 != null && cur2 != null){
            if(cur1.no <= cur2.no){
                pre=cur1;
                cur1=cur1.next;
            }else {
                next=cur2.next;
                pre.next=cur2;
                cur2.next=cur1;
                pre=cur2;
                cur2=next;
            }
        }
        pre.next=cur1==null ? cur2 : cur1;
        return head;

    }

}


