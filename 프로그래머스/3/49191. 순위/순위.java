/*
배열 업데이트

*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = 100;
        int[][] arr = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) arr[i][j] = INF;
            }
        }
        
        for(int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            
            arr[win][lose] = 1;
            arr[lose][win] = -1;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        //i가 k 이겼고, k가 j이김 = i <- k <- j = i <- j
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            boolean flag = true;
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] == INF) flag = false;
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}