package com.lyj.structure;


import java.util.Random;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description:
 **/
public class ArrayQueueDemo {

    public static void main(String[] args) throws Exception {
        int max=5;
        ArrayQueue aq=new ArrayQueue(max);
        for(int i=0;i<5;i++){
            aq.addQueue(new Random().nextInt());
        }
        System.out.println("showQueue");
        aq.showQueue();
        System.out.println("popQueue");
        System.out.println(aq.popQueue());
        System.out.println(aq.popQueue());
        System.out.println(aq.popQueue());
        System.out.println("headQueue");
        System.out.println(aq.headQueue());
        aq.showQueue();

    }
}
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        this.front=-1;//指向头部
        this.rear=-1;//指向尾部
    }
    public  boolean isFull(){
        return this.rear==this.maxSize-1;
    }
    public  boolean isEmpty(){
        return this.rear==this.front;
    }
    public  void addQueue(int n){
        //队列未满
        if(isFull()){
            System.out.printf("队列已满");
            return;
        }
        rear++;//队尾后移
        arr[rear]=n;
    }
    public  int popQueue() throws Exception {
        //队列未满
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        front++;//队尾后移
        return arr[front];
    }

    public  void printQueue() {
        for(int i : arr){
            System.out.println("队列数据：");
            System.out.print(i);
        }
    }
    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

}
