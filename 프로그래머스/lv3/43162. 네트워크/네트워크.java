import java.io.*;
import java.util.*;

class Solution {
    static boolean[] flag;
    static int ans = 0;
    public int solution(int n, int[][] computers) {
        flag = new boolean[n];
        
        for(int i = 0 ; i< n; i++){
            if(!flag[i]){
                dfs(computers,i,n);
                ans++;
            }
        }
        return ans;
    }
    
    private static void dfs(int[][] computers, int node,int n){
        flag[node] = true;
        
        for(int i = 0; i < n; i++){
            if(!flag[i] && computers[node][i] == 1){
                dfs(computers,i,n);
            }
        }
    }
}