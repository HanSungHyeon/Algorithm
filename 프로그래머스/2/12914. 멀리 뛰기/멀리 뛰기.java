/*
n = 1 -> 1
n = 2 -> 2
n = 3 -> 3
n = 4 -> 5
n = 5 -> 8
n = 6 -> 13
*/

import java.io.*;
import java.util.*;

class Solution {
    static long[] dp;
    
    public long solution(int n) {
        dp = new long[n + 1];
       
        long answer = dp(n);
        return answer;
    }
    
    static long dp(int n) {
        if(n == 1) return 1;
        
        if(n == 2) return 2;
        
        if(dp[n] > 0) return dp[n];
        
        return dp[n] = (dp(n - 1) + dp(n - 2)) % 1234567;
    }
}