package com.lyj.structure;

import java.util.Random;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: 环形队列
 **/
public class CircleQueueDemo {
    public static void main(String[] args) throws Exception{
        CircleQueue cq=new CircleQueue(10);
        for(int i=0;i<6;i++){
            cq.addQueue(new Random().nextInt());
        }
        System.out.println("showQueue");
        cq.showQueue();
        System.out.println("popQueue");
        System.out.println(cq.popQueue());
        System.out.println(cq.popQueue());
        System.out.println(cq.popQueue());
        System.out.println("headQueue");
        System.out.println(cq.headQueue());
        cq.showQueue();
        for(int i=0;i<3;i++){
            cq.addQueue(new Random().nextInt());
        }
        System.out.println("modifyQueue");
        cq.showQueue();
        //System.out.println("headQueue");
        //System.out.println(cq.headQueue());
        System.out.println("last-modifyQueue");
        for(int i=0;i<5;i++){
            cq.addQueue(new Random().nextInt());
        }
        System.out.println("modifyQueue");
        cq.showQueue();
    }
}

class CircleQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int maxSize) {
         this.maxSize =maxSize;
         arr=new int[maxSize];
    }

    //当队首和队尾相等时有2种情况。1是初始队列，队列为空，2是队列数据装满，队尾回到队首的位置，形成闭环，判断为空不能以二者是否相等来断定；
    public boolean isEmpty(){
        for(int i:arr){
            if(i!=0){
                return false;
            } ;
        }
        return  true;
    }
    //环形队列判断队满：
    public boolean isFull(){
        if(rear==front&&rear==0) {
            return false;
        }
        return (rear)%maxSize== front;
    }

    //获取队列中有多少个数
    public int getNum(){
        return ( rear+ maxSize- front)%maxSize;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }

        //直接将数据加入
        arr[rear] = n;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear+1) % maxSize;
    }
    public  int popQueue() throws Exception {
        //队列未满
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        int value =  arr[ front];
         arr[ front]=0;
         front = ( front+1)%maxSize;
        return value;
    }
    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        //处理队头数据最后插入的情况
        for (int i = 0; i <  maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize,  arr[i%maxSize]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return  arr[ front];
    }
}
