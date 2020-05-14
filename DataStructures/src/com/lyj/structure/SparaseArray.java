package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description:
 **/
public class SparaseArray {

    public static void main(String[] args) {
        // ����һ��ԭʼ�Ķ�ά���� 11 * 11
        // 0: ��ʾû�����ӣ� 1 ��ʾ ���� 2 ������
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        // ���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά����~~");
        for(int row[]:chessArr1){
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // ����ά���� ת ϡ�������˼¼
        // 1. �ȱ�����ά���� �õ���0���ݵĸ���
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. ������Ӧ��ϡ������
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;
        int count = 0; //count ���ڼ�¼�ǵڼ�����0����
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
        // ���ϡ���������ʽ
        System.out.println();
        System.out.println("�õ�ϡ������Ϊ~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        // 2. ������ά����
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
            System.out.printf("%d\t%d\t\n", chessArr2[i][0], chessArr2[i][1]);
        }

        for (int i = 0; i < chessArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", chessArr2[i][0], chessArr2[i][1], sparseArr[i][2]);
        }

        }

        //ϡ������תΪ��ά����



}
