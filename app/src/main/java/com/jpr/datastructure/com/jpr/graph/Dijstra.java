package com.jpr.datastructure.com.jpr.graph;

import static android.R.attr.id;

/**
 * 类描述:迪杰斯特拉算法---求最短路径
 * 创建日期:2018/3/29 on 16:31
 * 作者:JiaoPeiRong
 */

public class Dijstra {
    private static final int MAXVEX = 9;
    private int shortTablePath[] = new int[MAXVEX];//V0到某个顶点的最短路径
    private static final int MAX_WEIGHT = 1000;//标示无穷大,即两顶点之间不存在连接

    public static void main(String[] args) {
        Graph graph = new Graph(MAXVEX);
        graph.createGraph();
        new Dijstra().dijstra(graph);

    }

    private void dijstra(Graph graph) {
        int min;//行的最小值
        int k = 0;//从v0开始,这里写死了
        boolean isGetPath[] = new boolean[MAXVEX];//自己到自己不需要判断
        //获取第一行的数据
        for (int i = 0; i < graph.getVertexSeze(); i++) {
            shortTablePath[i] = graph.getMatrix()[0][i];
        }
        shortTablePath[0] = 0;//v0到v0的距离
        isGetPath[0] = true;
        for (int v = 1; v < graph.getVertexSeze(); v++) {
            min = MAX_WEIGHT+1;
            //拿到每行的最小值
            for (int w = 0; w < graph.getVertexSeze(); w++) {
                if (!isGetPath[w] && shortTablePath[w] < min) {
                    k = w;
                    min = shortTablePath[w];
                }
            }
            //将最小值设置为true,自己到自己不需要判断
            isGetPath[k] = true;
            //遍历第k行
            for (int j = 0; j < graph.getVertexSeze(); j++) {
                if (!isGetPath[j] && (min + graph.getMatrix()[k][j]) < shortTablePath[j]) {
                    shortTablePath[j] = min + graph.getMatrix()[k][j];
                }
            }
        }
        for (int i = 0; i < shortTablePath.length; i++) {
            System.out.println("V0到V" + i + "的最短路径为:" + shortTablePath[i]);
        }

    }

    /**
     * 使用邻接矩阵构建图
     */
    static class Graph {
        private int vertexSeze;//顶点数量
        private int[] vertexs;//顶点数组
        private int[][] matrix;//矩阵

        public Graph(int vertexSeze) {
            this.vertexSeze = vertexSeze;
            matrix = new int[vertexSeze][vertexSeze];
            vertexs = new int[vertexSeze];
        }

        public int getVertexSeze() {
            return vertexSeze;
        }

        public void setVertexSeze(int vertexSeze) {
            this.vertexSeze = vertexSeze;
        }

        public int[] getVertexs() {
            return vertexs;
        }

        public void setVertexs(int[] vertexs) {
            this.vertexs = vertexs;
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        /**
         * 构建矩阵
         */
        private void createGraph() {
            int[] a1 = new int[]{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            int[] a2 = new int[]{1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            int[] a3 = new int[]{5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
            int[] a4 = new int[]{MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
            int[] a5 = new int[]{MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
            int[] a6 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
            int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
            int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
            int[] a9 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};

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
}
