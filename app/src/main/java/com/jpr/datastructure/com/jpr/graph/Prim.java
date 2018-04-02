package com.jpr.datastructure.com.jpr.graph;

/**
 * 类描述:普里姆算法,求最小生成树
 * 见图片:mipmap-xxhdpi/prim.png
 * 创建日期:2018/3/29 on 16:25
 * 作者:JiaoPeiRong
 */

public class Prim {
    private int[] vertexts;//顶点数组
    private static int[][] matrix;
    private static final int MAX_WEIGHT = 1000;//标示顶点与顶点之间没有联系
    private static int vertexSize = 9;//顶点数量

    public static void main(String[] args) {
        initGraph();
        prim();
    }

    /**
     * 普里姆算法
     */
    private static void prim() {
        int[] lowcost = new int[vertexSize];//存放到下个顶点的距离,称之为距离数组
        int[] adjvex = new int[vertexSize];//存放最小生成树的顶点
        //距离数组默认矩阵第一行
        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = matrix[0][i];
        }
        //初始化一些变量
        int min, minId, sum = 0;
        //一共n-1条边,所以遍历vertexSize-1次就可以
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            minId = 0;
            //获取一行中的最小数据,即到下个顶点的最短距离;从1开始遍历,因为V0是出发点,略过
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] < min && lowcost[j] > 0) {
                    min = lowcost[j];
                    minId = j;
                }
            }
            System.out.println("顶点:" + adjvex[minId] + "权值:" + min);
            sum += min;
            lowcost[minId] = 0;
            //将第minId行的较小数据覆盖lowcost中的数据,从1开始遍历,因为V0是出发点,略过
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]) {
                    lowcost[j] = matrix[minId][j];
                    adjvex[j] = minId;
                }
            }

        }
        System.out.println("最小生成树权值和:" + sum);
    }

    /**
     * 初始化graph
     */
    private static void initGraph() {
        matrix = new int[vertexSize][vertexSize];
        int[] a1 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] a6 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] a7 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] a9 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;
        matrix[3] = a4;
        matrix[4] = a5;
        matrix[5] = a6;
        matrix[6] = a7;
        matrix[7] = a8;
        matrix[8] = a9;
    }

}
