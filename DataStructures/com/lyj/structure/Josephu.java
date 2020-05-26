package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: 约瑟夫问题：Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，
 * 约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，它的下一位又从1开始报数，
 * 数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 * 单向环形链表
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
* @description: 单向环形链表
**/
class CycleSingleLinkedList{

    public Boy first=null;//头节点指针


    public void addBoy(int nums){
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy culBoy=null;// 辅助指针，帮助构建环形链表
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                culBoy=first;
            }else{
                culBoy.setNext(boy);//将boy 加入环形链中
                boy.setNext(first);//boy 连接第一个节点；
                culBoy=boy;//culBoy 移到boy 上
            }

        }
    }

    // 遍历当前的环形链表
    public void showBoy() {
      if(first ==null){
          System.out.println("链表为空");
      }
      Boy tmp=first;
      while (true){
          System.out.println("boy编号："+tmp.getNo());
          if(tmp.next == first){
              System.out.println("输出完毕");
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
    * @description: 约瑟夫计数问题
     * @param start 计数起点
     * @param cycle  计数循环次数
     * @param nums  留在圈里的小孩人数
    **/
    public void countNum(int start,int cycle,int nums){
        if(first ==null){
            System.out.println("链表为空");
        }
        if (first == null || start < 1 || start > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        Boy helper=first;//辅助指针
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < start - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if(helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for(int j = 0; j < cycle - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }



    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            //helper指向环形链表的最后一位
            if (helper.getNext() == first) { // 说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while(true) {
            if(helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //

        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }

}
