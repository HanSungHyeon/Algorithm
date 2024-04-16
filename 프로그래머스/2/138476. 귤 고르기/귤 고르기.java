/*
정렬
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int num, count;
        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    static int[] count;
    public int solution(int k, int[] tangerine) {
        count = new int[10000001];
        
        for(int n : tangerine) {
            count[n]++;
        }
        
        List<Node> list = new ArrayList<>();
        
        for(int i = 1; i < count.length; i++) {
            list.add(new Node(i, count[i]));
        }
        
        list.sort((o1,o2) -> o2.count - o1.count);
        
        int answer = 0;
        for(Node node : list) {
            if(k <= 0) break;
            
            k -= node.count;
            answer++;
        }
        
        return answer;
    }
}