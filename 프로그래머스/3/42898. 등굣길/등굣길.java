/*
아래, 오른쪽으로만 이동 가능
현재 위치 기준으로 왼쪽 위 숫자를 더하면 됨
0행 = 우물이 없다는 가정하에 무조건 1
    = 만약 우물이 있다면 우물 이후로는 무조건 0
0열 = 우물이 없다는 가정하에 무조건 1
    = 만약 우물이 있다면 우물 이후로는 무조건 0

*/

import java.io.*;
import java.util.*;

class Solution {
    static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];
        
        for(int i = 0; i < puddles.length; i++) {
            int col = puddles[i][0] - 1;
            int row = puddles[i][1] - 1;
            
            dp[row][col] = -1;
        }
        
        for(int i = 1; i < n; i++) {
            if(dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < m; i++) {
            if(dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        
        answer = dp(n - 1,m - 1);
        
        return answer;
    }
    
    static int dp(int x, int y) {
        if(dp[x][y] == -1) return 0;
        
        if(dp[x][y] > 0) return dp[x][y];
        
        if(x == 0 || y == 0) return 0;
        
        return dp[x][y] = (dp(x - 1, y) + dp(x, y - 1)) % 1000000007;
    }
}