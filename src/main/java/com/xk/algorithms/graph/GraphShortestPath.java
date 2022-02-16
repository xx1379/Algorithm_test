package com.xk.algorithms.graph;

import java.util.*;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2022/2/16 22:45
 * 求图的最短路径
 */
public class GraphShortestPath {
    /**
     * 1. 求图中A到G的的最短路径
     * （1）对于无权图，直接使用广度优先遍历算法，从A到G相隔层次最少的即为最短路径
     * （2）对于有权图，可使用Dijkstra（迪杰斯特拉）算法，是单源最短路径算法
     * 创建距离表，每次找距离起点最近的点，遍历邻节点，刷新到距离表中
     */

    public static int[] dijkstra(Graph graph, int start) {
        // 图的顶点数量
        int size = graph.vertexes.length;
        // 创建距离表，存储从起点到每一个顶点的临时距离，并初始化，到达每个顶点的路径代价默认为无穷大
        int[] distance = new int[size];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // 起点到自身距离为0
        distance[start] = 0;

        // 优先队列，distance较小的排在前面
        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        // 从起点start开始bfs
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            // 如果只想获得一个节点的距离，这里判断直接返回即可
//            if (curState.id == end) {
//                return curState.distance;
//            }

            if (curState.distance > distance[curState.id]) {
                // 已经有一条更短的路径到达curState节点了
                continue;
            }
            // 将当前节点的相邻节点加入队列
            for (Edge edge : graph.adj[curState.id]) {
                int distanceToNextNode = distance[curState.id] + edge.weight;
                // 如果距离更短，更新距离表并加入队列
                if (distanceToNextNode < distance[edge.index]) {
                    distance[edge.index] = distanceToNextNode;
                    pq.offer(new State(edge.index, distanceToNextNode));
                }
            }
        }
        return distance;
    }

    private static class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distance;

        State(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.vertexes[0] = new Vertex("A");
        graph.vertexes[1] = new Vertex("B");
        graph.vertexes[2] = new Vertex("C");
        graph.vertexes[3] = new Vertex("D");
        graph.vertexes[4] = new Vertex("E");
        graph.vertexes[5] = new Vertex("F");
        graph.vertexes[6] = new Vertex("G");
        graph.adj[0].add(new Edge(1, 5));
        graph.adj[0].add(new Edge(2, 2));
        graph.adj[1].add(new Edge(0, 5));
        graph.adj[1].add(new Edge(3, 1));
        graph.adj[1].add(new Edge(4, 6));
        graph.adj[2].add(new Edge(0, 2));
        graph.adj[2].add(new Edge(3, 6));
        graph.adj[2].add(new Edge(5, 8));
        graph.adj[3].add(new Edge(1, 1));
        graph.adj[3].add(new Edge(2, 6));
        graph.adj[3].add(new Edge(4, 1));
        graph.adj[3].add(new Edge(5, 2));
        graph.adj[4].add(new Edge(1, 6));
        graph.adj[4].add(new Edge(3, 1));
        graph.adj[4].add(new Edge(6, 7));
        graph.adj[5].add(new Edge(2, 8));
        graph.adj[5].add(new Edge(3, 2));
        graph.adj[5].add(new Edge(6, 3));
        graph.adj[6].add(new Edge(4, 7));
        graph.adj[6].add(new Edge(5, 3));
        int[] distance = dijkstra(graph, 0);
        System.out.println(distance[6]);
    }

    /**
     * 图的顶点
     */
    private static class Vertex {
        String data;

        Vertex(String data) {
            this.data = data;
        }
    }

    /**
     * 图的边
     */
    private static class Edge {
        int index;
        int weight;

        Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    /**
     * 图
     */
    private static class Graph {
        private Vertex[] vertexes;
        private LinkedList<Edge>[] adj;

        Graph(int size) {
            vertexes = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
        }
    }
}
