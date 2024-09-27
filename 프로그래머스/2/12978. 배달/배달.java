/*
1번 마을에서
K 시간 이하로 배달 가능한 마을 개수
N = 50
다익스트라
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int INF = 987654321;
    static int[] dist;
    static List<Node>[] list;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        dist = new int[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            if(i != 1) dist[i] = INF;
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int w = road[i][2];
            
            list[from].add(new Node(to, w));
            list[to].add(new Node(from, w));
        }
        dijkstra();
        
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()) {
            int cur = pq.peek().v;
            int w = pq.peek().w;
            pq.poll();
            
            if(dist[cur] != w) continue;
            
            for(Node node : list[cur]) {
                if(dist[node.v] > dist[cur] + node.w) {
                    dist[node.v] = dist[cur] + node.w;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}