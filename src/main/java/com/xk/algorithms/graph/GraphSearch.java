package com.xk.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2022/2/16 22:21
 */
public class GraphSearch {

    /**
     * 图的顶点
     */
    private static class Vertex {
        int data;

        Vertex(int data) {
            this.data = data;
        }
    }

    /**
     * 图（邻接表形式）
     */
    private static class Graph {
        private final int size;
        private Vertex[] vertexes;
        private LinkedList<Integer>[] adj;

        Graph(int size) {
            this.size = size;
            vertexes = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertexes[i] = new Vertex(i);
                adj[i] = new LinkedList<>();
            }
        }
    }

    /**
     * 深度优先遍历:递归
     */
    public static void dfs(Graph graph, int start, boolean[] visited) {
        System.out.println(graph.vertexes[start].data);
        visited[start] = true;
        for (int index : graph.adj[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    /**
     * 广度优先遍历：队列
     */
    public static void bfs(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[graph.size];
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (visited[vertex]) {
                continue;
            }
            System.out.println(graph.vertexes[vertex].data);
            visited[vertex] = true;
            for (int index : graph.adj[vertex]) {
                queue.offer(index);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);

        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);

        graph.adj[2].add(0);

        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);

        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);

        System.out.println("图的深度优先遍历： ");
        dfs(graph, 0, new boolean[graph.size]);
        System.out.println("图的广度优先遍历： ");
        bfs(graph, 0);
    }
}
