/*
간선 많음 = 프림
간선 적음 = 크루스칼
걍 둘 다 해
1. 프림
2. 크루스칼
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int v, e;
        public Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }
    static boolean[] flag;
    static List<Node>[] list;
    public int solution(int n, int[][] costs) {
        list = new ArrayList[n];
        flag = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];;
            int w = cost[2];
            
            list[from].add(new Node(to, w));
            list[to].add(new Node(from, w));
        }
        
        int answer = prim();
        return answer;
    }
    static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.e - o2.e);
        pq.add(new Node(1, 0));
        int sum = 0;
        
        while(!pq.isEmpty()) {
            int cur = pq.peek().v;
            int e = pq.peek().e;
            pq.poll();
            
            if(flag[cur]) continue;
            
            flag[cur] = true;
            sum += e;
            
            for(Node node : list[cur]) {
                if(!flag[node.v]) pq.add(new Node(node.v, node.e));    
            }
        }
        return sum;
    }
}