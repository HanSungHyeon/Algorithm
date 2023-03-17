import java.io.*;
import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    static boolean[] flag;
    
    private static boolean isCheck(String target, String[] words){
    for(int i =0 ; i < words.length; i++){
        if(target.equals(words[i])) return true;
        }
        return false;
    }

private static void dfs(String begin, String target, String[] words, int num){
    if(num >= ans) return;
    
    if(begin.equals(target)){
        ans = Math.min(ans , num);
        return;
    }
    for(int i = 0; i < words.length; i++){
        if(!flag[i]){
            if(convert(begin,words[i])){
                flag[i] = true;
                dfs(words[i], target,words,num + 1);
                flag[i] = false;
            }
        }
    }

    }
    private static boolean convert(String str1, String str2){
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        
        int num = 0;
        for(int i = 0; i< arr1.length; i++){
            if(arr1[i].equals(arr2[i])) continue;
            else num++;
        }
        if(num == 1) return true;
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        if(isCheck(target,words)){
            flag = new boolean[words.length];
            dfs(begin,target,words,0);
            return ans;
        }
        else return 0;
    }
}