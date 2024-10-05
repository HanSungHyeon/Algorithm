/*
bfs, dfs
bfs가 더 마음 편할듯
N^2

*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int l, r;
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public int solution(int n) {
        int answer = bfs(n);
        return answer;
    }
    
    static int bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));
        int count = 0;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.l == n && node.r == n) count++;
            
            //왼쪽 가로를 더 만들 수 있는 경우
            if(node.l < n) {
                q.add(new Node(node.l + 1, node.r));
                
                if(node.r < node.l) {
                    q.add(new Node(node.l, node.r + 1));
                }
            } else if(node.l == n) {
                if(node.r < node.l) {
                    q.add(new Node(node.l, node.r + 1));
                }
            }
        }
        return count;
    }
}