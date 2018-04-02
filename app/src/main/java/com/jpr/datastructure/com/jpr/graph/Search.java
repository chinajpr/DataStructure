package com.jpr.datastructure.com.jpr.graph;

import static java.util.Locale.LanguageRange.MAX_WEIGHT;

/**
 * 类描述:图的遍历
 * 深度优先遍历和广度优先遍历
 * 创建日期:2018/4/2 on 14:34
 * 作者:JiaoPeiRong
 */
public class Search {
    private static final int MAX_WEIGHT = 1000;
    private static final int vertexSize = 9;
    private static int[][] matrix;
    public static void main(String[] args) {
        initGraph();
        depthFirstSearch();
    }

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

    /**
     * 深度优先遍历
     */
    private static void depthFirstSearch() {

    }

    /**
     * 广度优先遍历
     */
    private static void broadFirstSearch() {

    }
}
