package com.lyj.structure;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

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

        // ����һ�µ�����ķ�ת����
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
}
