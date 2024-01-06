import java.io.*;
import java.util.*;

class Solution {
    public static List<Integer>[] list;
    public static boolean[] flag;
    public static int count, ans = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        flag = new boolean[n + 1];
        list = new ArrayList[n + 1];
        
        init(n);
        
        for(int i = 0; i < wires.length; i++) {
            Arrays.fill(flag, false);
            init(n);
            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue;
                
                int from = wires[j][0];
                int to = wires[j][1];
                
                list[from].add(to);
                list[to].add(from);
            }
            count = 1;
            dfs(1);
            ans = Math.min(ans, Math.abs(n - (count * 2)));
            // ans = Math.min(Math.abs(n - (count * 2)), ans);
        }
        return ans;
    }
    public static void init(int n) {
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
    }
    
    //dfs 한 번만 태우고 갯수 나온거랑 위에서 받아온 이랑 빼버리면 될 듯??
    public static void dfs(int node){
        flag[node] = true;
        
        for(int i : list[node]) {
            if(!flag[i]) {
                count++;
                dfs(i);
            }
        }
    }
}