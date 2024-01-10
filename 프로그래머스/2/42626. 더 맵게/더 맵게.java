import java.io.*;
import java.util.*;

class Solution {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    public int solution(int[] scoville, int K) {
        int ans = 0;
        for(int i : scoville) 
            pq.add(i);
        
        while(!isCheck(K)) {
            if(pq.size() == 1 && pq.peek() != 0) return -1;
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            pq.add(num1 + (num2 * 2));
            ans++;
        }
        return ans;
    }
    public static boolean isCheck(int k) {
        for(int i : pq) {
            if(i < k) return false;
        }
        return true;
    }
}