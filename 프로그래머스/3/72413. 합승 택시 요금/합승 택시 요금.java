import java.io.*;
import java.util.*;
    
class Solution {
    static int[][] dist;
    static int INF = 10000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }
        
        for(int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int edge = fares[i][2];
            
            dist[from][to] = edge;
            dist[to][from] = edge;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1 ; j <= n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int fair = dist[s][i];
            int ad = dist[i][a];
            int bd = dist[i][b];
            
            min = Math.min(min, fair + ad + bd);
        }
        
        return min;
    }
    
}