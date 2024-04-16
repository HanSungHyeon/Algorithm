import java.io.*;
import java.util.*;

class Solution {
    static int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        
        return fibo(n);
    }
    
    static int fibo(int num) {
        if(num == 1) return 1;
        
        if(num == 0) return 0;
        
        if(dp[num] > 0) return dp[num];
        
        return dp[num] = (fibo(num - 1) + fibo(num - 2)) % 1234567;
    }
}