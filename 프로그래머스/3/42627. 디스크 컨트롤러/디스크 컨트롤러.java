import java.io.*;
import java.util.*;

class Solution {
    public static class Node{
        int start, complete;
        public Node(int start, int complete) {
            this.start = start;
            this.complete = complete;
        };
    }
    public static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
        return o1.complete - o2.complete;
    });
    public static ArrayList<Node> list = new ArrayList<>();
    
    public int solution(int[][] jobs) {
        for(int[] ints : jobs) {
            pq.add(new Node(ints[0],ints[1]));
        }
        int size = jobs.length;
        int time = 0;
        int ans = 0;
        while(!pq.isEmpty()) {
            //현재 시점에서 뺄 수 있는 놈 찾기
            int pqSize = pq.size();
            for(int i = 0; i < pqSize; i++) {
                if(pq.peek().start > time) list.add(pq.poll());
                else break;
            }
            //현재 시점에 작업 할 수있는 놈이 없으면 걍 시간 늘리고 다음거 타면서
            if(pq.isEmpty()) {
                time++;
                insert();
                continue;
            }
            Node n = pq.poll();
            ans += time + n.complete - n.start;
            time += n.complete;
            insert();
        }
        ans /= size;
        return ans;
    }
    public static void insert() {
        for(Node n : list) {
            pq.add(n);
        }
        list.clear();
    }
}