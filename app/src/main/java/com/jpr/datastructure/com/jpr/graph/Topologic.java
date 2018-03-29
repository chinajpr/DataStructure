package com.jpr.datastructure.com.jpr.graph;

import java.util.Stack;

/**
 * 类描述:图的拓扑排序
 * 使用邻接表数据结构标示图
 * 见图:mipmap-xxhdpi/topologin.png 和 mipmap-xxhdpi/topologin1.png
 * 创建日期:2018/3/29 on 14:00
 * 作者:JiaoPeiRong
 */

public class Topologic {
    private VertexNode[] adjList;//邻接顶点的一维数组
    private int numVertexes = 14;//顶点个数

    public static void main(String[] args) {
        Topologic topologic = new Topologic();
        topologic.createGraph();
        topologic.topologicSort();
    }

    /**
     * 拓扑排序
     */
    private void topologicSort() {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int k = 0;
        for (int i = 0; i < numVertexes; i++) {
            if (adjList[i].in == 0) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            System.out.println("顶点: " + adjList[pop].data);
            count++;
            for (EdgeNode node = adjList[pop].firstEdge; node != null; node = node.next) {
                k = node.adjVert;
                if (--adjList[k].in == 0) {
                    stack.push(k);//入度为0,入栈
                }
                //注意细节的坑:
//                int s = adjList[k].in - 1;
//                if (s == 0) {
//                    stack.push(k);
//                }

            }
        }
    }

    /**
     * 构建图,使用邻接表构建
     */
    private void createGraph() {
        VertexNode node0 = new VertexNode(0, "v0");
        VertexNode node1 = new VertexNode(0, "v1");
        VertexNode node2 = new VertexNode(2, "v2");
        VertexNode node3 = new VertexNode(0, "v3");
        VertexNode node4 = new VertexNode(2, "v4");
        VertexNode node5 = new VertexNode(3, "v5");
        VertexNode node6 = new VertexNode(1, "v6");
        VertexNode node7 = new VertexNode(2, "v7");
        VertexNode node8 = new VertexNode(2, "v8");
        VertexNode node9 = new VertexNode(1, "v9");
        VertexNode node10 = new VertexNode(1, "v10");
        VertexNode node11 = new VertexNode(2, "v11");
        VertexNode node12 = new VertexNode(1, "v12");
        VertexNode node13 = new VertexNode(2, "v13");

        //构建数组
        adjList = new VertexNode[numVertexes];
        adjList[0] = node0;
        adjList[1] = node1;
        adjList[2] = node2;
        adjList[3] = node3;
        adjList[4] = node4;
        adjList[5] = node5;
        adjList[6] = node6;
        adjList[7] = node7;
        adjList[8] = node8;
        adjList[9] = node9;
        adjList[10] = node10;
        adjList[11] = node11;
        adjList[12] = node12;
        adjList[13] = node13;

        //构建链表
        node0.firstEdge = new EdgeNode(11);
        node0.firstEdge.next = new EdgeNode(5);
        node0.firstEdge.next.next = new EdgeNode(4);
        node1.firstEdge = new EdgeNode(8);
        node1.firstEdge.next = new EdgeNode(4);
        node1.firstEdge.next.next = new EdgeNode(2);
        node2.firstEdge = new EdgeNode(9);
        node2.firstEdge.next = new EdgeNode(6);
        node2.firstEdge.next.next = new EdgeNode(5);
        node3.firstEdge = new EdgeNode(13);
        node3.firstEdge.next = new EdgeNode(2);
        node4.firstEdge = new EdgeNode(7);
        node5.firstEdge = new EdgeNode(12);
        node5.firstEdge.next = new EdgeNode(8);
        node6.firstEdge = new EdgeNode(5);
        node8.firstEdge = new EdgeNode(7);
        node9.firstEdge = new EdgeNode(11);
        node9.firstEdge.next = new EdgeNode(10);
        node10.firstEdge = new EdgeNode(13);
        node12.firstEdge = new EdgeNode(9);

    }

    /**
     * 邻接顶点---数组中的顶点
     */
    class VertexNode {
        private int in;//入度
        private String data;//值
        private EdgeNode firstEdge;//指向链表的指针

        public VertexNode(int in, String data) {
            this.in = in;
            this.data = data;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public EdgeNode getFirstEdge() {
            return firstEdge;
        }

        public void setFirstEdge(EdgeNode firstEdge) {
            this.firstEdge = firstEdge;
        }
    }

    /**
     * 边表顶点---链表中的顶点
     */
    class EdgeNode {
        private int adjVert;//值,这里和下标一致
        private EdgeNode next;//下一个的指针
        private int weight;

        public EdgeNode(int adjVert) {
            this.adjVert = adjVert;
        }

        public int getAdjVert() {
            return adjVert;
        }

        public void setAdjVert(int adjVert) {
            this.adjVert = adjVert;
        }

        public EdgeNode getNext() {
            return next;
        }

        public void setNext(EdgeNode next) {
            this.next = next;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
