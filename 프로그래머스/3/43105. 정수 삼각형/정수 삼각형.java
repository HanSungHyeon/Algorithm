/*
10000 * 500 = 5000000
*/

import java.io.*;
import java.util.*;

class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        int col = triangle[row - 1].length;
        dp = new int[row][col];
        
        for(int i = 0; i < col; i++) {
            answer = Math.max(dp(row - 1, i, triangle), answer);
        }
        return answer;
    }
    
    static int dp(int x, int y, int[][] triangle) {
        if(x == 0 && y == 0) return triangle[x][y];
        
        //맨 왼쪽은 위로만
        if(y == 0)  {
            return dp(x - 1, y, triangle) + triangle[x][y];   
        }
        //맨 오른쪽은 왼쪽 위
        if(x == y) return dp(x - 1, y - 1, triangle) + triangle[x][y];
        //값 이미 있으면 걍 리턴
        if(dp[x][y] > 0) return dp[x][y];
        
        return dp[x][y] = Math.max(dp(x - 1, y, triangle), dp(x - 1, y - 1, triangle)) + triangle[x][y];
    }
}