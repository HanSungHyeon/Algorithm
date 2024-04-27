

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        
        //초기화
        for(int i : topping) {
            b.put(i, b.getOrDefault(i, 0) + 1);
        }
        
        for(int i = 0; i < topping.length - 1; i++) {
            a.put(topping[i], a.getOrDefault(topping[i], 0) + 1);
            
            //b하나 뜯어내야함
            int v = b.get(topping[i]);
            
            if(v == 1) b.remove(topping[i]);
            
            else b.put(topping[i], v - 1);
            
            if(a.size() == b.size()) answer++;
        }
        
        return answer;
    }
    
}