/*

*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        String g;
        int p;
        public Node(String g, int p) {
            this.g = g;
            this.p = p;
        }
    }
    static class Node2 {
        int idx, p;
        public Node2(int idx, int p) {
            this.idx = idx;
            this.p = p;
        }
    }
    static List<Integer> tmp = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
        for(String key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }
        
        while(!pq.isEmpty()) {
            String gen = pq.peek().g;
            pq.poll();
            List<Node2> list = new ArrayList<>();    
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(gen)) {
                    list.add(new Node2(i, plays[i]));
                }
            }
            list.sort((o1, o2) -> (o2.p - o1.p));
            int count = 0;
            for(Node2 node : list) {
                tmp.add(node.idx);
                count++;
                if(count == 2) break;
            }
        }
        
        int[] answer = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}