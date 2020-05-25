package com.lyj.structure;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

import java.util.Stack;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: ��ͷ���ĵ�����
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
//���в���
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //����
        singleLinkedList.addHero(hero1);
        singleLinkedList.addHero(hero4);
        singleLinkedList.addHero(hero2);
        singleLinkedList.addHero(hero3);
        System.out.println("ԭ����������~~");
        singleLinkedList.list();

 /*       // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
        singleLinkedList.list();

        //����Ҫ������
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        System.out.println("������˳���������~~");
        //����
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

    //����ͷ�ڵ�
    public HeroNode getHead() {
        return head;
    }
    //����
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

    //����б�
    public void list(){
        if(head.next == null){
            System.out.printf("����Ϊ�գ�");
            return;
        }
        HeroNode tmp=head;
        while(true){
            if(tmp.next == null){
                System.out.println("���������ϣ�");
                return;
            }
            System.out.println(tmp.next);
            tmp=tmp.next;
        }
    }

    //����
    //���������������;(�������������������ʧ�ܣ���������ʾ)
    public void addHeroByOrder(HeroNode hero){
        HeroNode tmp=head;
        boolean isExsit=false;
        while(true){
            //�Ѿ��������β
            if(tmp.next == null){
                break;
            }
            if(tmp.next.no > hero.no){ //�ҵ�λ��
                break;
            }else if(hero.no ==tmp.next.no){
                isExsit=true;
                break;
            }
            tmp=tmp.next;
        }
        if(isExsit){
            System.out.println("�Ѵ�����ͬ������Ӣ�ۣ�%d"+tmp.no);
        }else{
            //�����ݲ���
            hero.next=tmp.next;
            tmp.next=hero;
        }
    }


    // ����������Ч�ڵ�ĸ��� ��ȡ��������
    public  int getLength(HeroNode head) {
        int length = 0;
        HeroNode tmp = head;
        if(head.next == null){
            System.out.printf("����Ϊ�գ�");
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

    // ���ҵ������еĵ�����k�����
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

    //������ķ�ת
    public  HeroNode reverseLinkedList(HeroNode head) {
       //����Ϊ�ջ�ֻ��һ���ڵ�ֱ�ӷ���
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


    //�����ӡ 1.���������2 ʹ��ջ
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


    //�ϲ���������ĵ������ϲ�֮���������Ȼ����
    /*
    * 1. list 1,list2 ����list1��ʼ��������list2���жԱȣ�С�Ľڵ�ȡ�� ���з����µĽ�����
    * */
    public HeroNode combaine(HeroNode A,HeroNode B){

        //����Ϊ�ջ�ֻ��һ���ڵ�ֱ�ӷ���
        if(B.next == null || B.next.next == null) {
            return null;
        }
        //����Ϊ�ջ�ֻ��һ���ڵ�ֱ�ӷ���
        if(A.next == null || A.next.next == null) {
            return null;
        }

        //�����
        HeroNode res=new HeroNode();
        //��С���Ǹ��ڵ�
        HeroNode pre=new HeroNode();
        //������������α�
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


