/*
1 = 1
2 = 2
3 = 3
4 = 5
5 = 8
*/

import java.io.*;
import java.util.*;

class Solution {
    static int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        int answer = dp(n);
        return answer;
    }
    static int dp(int num) {
        if(num == 1) return 1;
        
        if(num == 2) return 2;
        
        if(dp[num] > 0) return dp[num];
        
        return dp[num] = (dp(num - 1) + dp(num - 2)) % 1000000007;
    }
}