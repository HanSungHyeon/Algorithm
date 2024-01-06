import java.io.*;
import java.util.*;

class Solution {
    public static boolean[] flag;
    public static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        flag = new boolean[dungeons.length];
        back(k, dungeons,0);

        return ans;
    }
    
    public static boolean isCheck(int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(dungeons[i][0] <= k && !flag[i]) return true;
        }
        return false;
    }
    
    //재귀
    public static void back(int k, int[][] dungeons,int count){
        if(!isCheck(k, dungeons)) {
            ans = Math.max(count, ans);
            
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(flag[i]) continue;
            
            if(dungeons[i][0] <= k) {
                flag[i] = true;
                back(k - dungeons[i][1], dungeons, count + 1);
                flag[i] = false;
            }
            
        }
    }
}