package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description:
 **/
public class SparaseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for(int row[]:chessArr1){
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 将二维数组 转 稀疏数组的思录
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        // 2. 创建二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
            System.out.printf("%d\t%d\t\n", chessArr2[i][0], chessArr2[i][1]);
        }

        for (int i = 0; i < chessArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", chessArr2[i][0], chessArr2[i][1], sparseArr[i][2]);
        }

        }

        //稀疏数组转为二维数组



}
