import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return ans;
    }
    public static void dfs(int[] numbers,int target,int sum,int idx){
    if(idx == numbers.length){
        if(sum == target) ans++;
        return;
    }
    
    dfs(numbers,target,sum + numbers[idx],idx + 1);
    dfs(numbers,target,sum - numbers[idx],idx + 1);
}   
    static int ans = 0;
}