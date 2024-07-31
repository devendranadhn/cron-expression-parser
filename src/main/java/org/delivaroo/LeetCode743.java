package org.delivaroo;

import java.util.*;

public class LeetCode743 {

    class Solution {

        class Edge {
            int src;
            int dest;
            int weight;

            Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        class Pair {
            int node;
            int dist;

            Pair(int node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {

            List<Edge>[] graph = new ArrayList[n+1];

            for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for(int[] array : times) {
                graph[array[0]].add(new Edge(array[0], array[1], array[2]));
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Pair pair = new Pair(k, 0);
            dist[k] = 0;

            Queue<Pair> queue = new LinkedList<>();
            queue.add(pair);
            boolean[] visited = new boolean[n+1];

            while(!queue.isEmpty()) {
                Pair curr = queue.poll();
                if(visited[curr.node]) continue;

                for(Edge edge : graph[curr.node]) {

                    if(dist[edge.src] + edge.weight < dist[edge.dest]) {
                        dist[edge.dest] = dist[edge.src] + edge.weight;
                    }
                    queue.offer(new Pair(edge.dest, dist[edge.dest]));
                }
                visited[curr.node] = true;
            }
            int max = Integer.MIN_VALUE;
            System.out.println(Arrays.toString(dist));
            for(int i = 1; i < dist.length; i++) {
                if(dist[i] == Integer.MAX_VALUE) return -1;
                if(dist[i] > max)  {
                    max = dist[i];
                }
            }
            return max;
        }
    }

}
