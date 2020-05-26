package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: Լɪ�����⣺Josephu  ����Ϊ������Ϊ1��2���� n��n����Χ��һȦ��
 * Լ�����Ϊk��1<=k<=n�����˴�1��ʼ����������m ���Ǹ��˳��У�������һλ�ִ�1��ʼ������
 * ����m���Ǹ����ֳ��У��������ƣ�ֱ�������˳���Ϊֹ���ɴ˲���һ�����ӱ�ŵ����С�
 * ����������
 **/
public class Josephu {


    public static void main(String[] args) {
        CycleSingleLinkedList list=new CycleSingleLinkedList();
        list.addBoy(125);
        list.showBoy();
        list.countNum(10,20,125);

        //list.countBoy(10,20,125);
    }

}

class Boy{
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
        this.next=this;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

/**
* @author: liuyuanjing
* @date: 2020/5/25 14:32
* @version: 2.0.0
* @description: ����������
**/
class CycleSingleLinkedList{

    public Boy first=null;//ͷ�ڵ�ָ��


    public void addBoy(int nums){
        if (nums < 1) {
            System.out.println("nums��ֵ����ȷ");
            return;
        }
        Boy culBoy=null;// ����ָ�룬����������������
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                culBoy=first;
            }else{
                culBoy.setNext(boy);//��boy ���뻷������
                boy.setNext(first);//boy ���ӵ�һ���ڵ㣻
                culBoy=boy;//culBoy �Ƶ�boy ��
            }

        }
    }

    // ������ǰ�Ļ�������
    public void showBoy() {
      if(first ==null){
          System.out.println("����Ϊ��");
      }
      Boy tmp=first;
      while (true){
          System.out.println("boy��ţ�"+tmp.getNo());
          if(tmp.next == first){
              System.out.println("������");
              break;
          }
          tmp=tmp.next;
      }
    }

    //
    /**
    * @author: liuyuanjing
    * @date: 2020/5/25 15:06
    * @version: 2.0.0
    * @description: Լɪ���������
     * @param start �������
     * @param cycle  ����ѭ������
     * @param nums  ����Ȧ���С������
    **/
    public void countNum(int start,int cycle,int nums){
        if(first ==null){
            System.out.println("����Ϊ��");
        }
        if (first == null || start < 1 || start > nums) {
            System.out.println("������������ ����������");
            return;
        }

        Boy helper=first;//����ָ��
        while (true) {
            if (helper.getNext() == first) { // ˵��helperָ�����С���ڵ�
                break;
            }
            helper = helper.getNext();
        }
        //С������ǰ������ first ��  helper �ƶ� k - 1��
        for(int j = 0; j < start - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if(helper == first) { //˵��Ȧ��ֻ��һ���ڵ�
                break;
            }
            //�� first �� helper ָ��ͬʱ ���ƶ� countNum - 1
            for(int j = 0; j < cycle - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //��ʱfirstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
            System.out.printf("С��%d��Ȧ\n", first.getNo());
            //��ʱ��firstָ���С���ڵ��Ȧ
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("�������Ȧ�е�С�����%d \n", first.getNo());

    }



    public void countBoy(int startNo, int countNum, int nums) {
        // �ȶ����ݽ���У��
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("������������ ����������");
            return;
        }
        // ����Ҫ������ָ��,�������С����Ȧ
        Boy helper = first;
        // ���󴴽�һ������ָ��(����) helper , ����Ӧ��ָ����������������ڵ�
        while (true) {
            //helperָ������������һλ
            if (helper.getNext() == first) { // ˵��helperָ�����С���ڵ�
                break;
            }
            helper = helper.getNext();
        }
        //С������ǰ������ first ��  helper �ƶ� k - 1��
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //��С������ʱ����first �� helper ָ��ͬʱ ���ƶ�  m  - 1 ��, Ȼ���Ȧ
        //������һ��ѭ��������֪��Ȧ��ֻ��һ���ڵ�
        while(true) {
            if(helper == first) { //˵��Ȧ��ֻ��һ���ڵ�
                break;
            }
            //�� first �� helper ָ��ͬʱ ���ƶ� countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //��ʱfirstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
            System.out.printf("С��%d��Ȧ\n", first.getNo());
            //��ʱ��firstָ���С���ڵ��Ȧ
            first = first.getNext();
            helper.setNext(first); //

        }
        System.out.printf("�������Ȧ�е�С�����%d \n", first.getNo());

    }

}
