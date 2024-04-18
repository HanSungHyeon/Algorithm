/*

*/

import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> wMap = new HashMap<String,Integer>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < want.length; i++) {
            wMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i <= discount.length - 10; i++) {
            if(isCheck(i, discount)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isCheck(int start, String[] discount) {
        HashMap<String, Integer> dMap = new HashMap<String, Integer>();
        
        for(int i = start; i < start + 10; i++) {
            dMap.put(discount[i], dMap.getOrDefault(discount[i], 0) + 1);
        }
        
        for(String key : wMap.keySet()) {
            if(wMap.get(key) != dMap.getOrDefault(key, -1)) 
                return false;
            
        }
        return true;
    }
}