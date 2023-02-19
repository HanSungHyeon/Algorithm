import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
        }
        
        while(n-- > 0){
            int num = pq.poll();
            
            if(num == 0) break;
            
            pq.add(--num);
        }
        
        long result = 0;
        for(int i : pq){
            result += (i * i);
        }
        return result;
    }
}