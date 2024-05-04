/*

*/

import java.io.*;
import java.util.*;

class Solution {
    static boolean[] flag;
    public int solution(int[][] routes) {
        int answer = 0;
        flag = new boolean[routes.length];
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        for(int i = 0; i < routes.length; i++) {
            if(flag[i]) continue;
            
            answer++;
            range(routes[i][1], routes);
        }
        
        if(flag[flag.length - 1]) return answer;
        
        return answer + 1;
    }
    
    static void range(int cam, int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            int in = arr[i][0];
            int out = arr[i][1];
            
            if(in <= cam && cam <= out) flag[i] = true;
        }
    }
}