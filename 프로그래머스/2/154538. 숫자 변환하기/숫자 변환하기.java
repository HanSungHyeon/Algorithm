/*
x = x + n
x = x * 2
x = x * 3
타겟 = 6
1 -> 2 -> 3 -> 4 -> 5 -> 6 = 6회
1 -> 2 -> 3 -> 6 = 4회
1 -> 3 -> 6 = 3회
*/

import java.io.*;
import java.util.*;

class Solution {
    static int[] dp;
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) return answer;
        
        dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        //bottom up
        for(int i = x; i <= y; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            
            if(i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            
            if(i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            
            if(i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
    
}