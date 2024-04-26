/*

*/

import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n,k);
        String[] arr = num.split("0");
        
        for(String s : arr) {
            if(s.isEmpty()) continue;
            
            long tmp = Long.parseLong(s);
            if(isPrime(tmp)) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long num){
        if(num <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}