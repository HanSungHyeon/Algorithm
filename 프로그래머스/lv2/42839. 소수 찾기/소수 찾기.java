import java.io.*;
import java.util.*;

class Solution {
    static int ans;
    static String[] arr,result;
    static boolean[] flag;
    static List<Integer> list = new ArrayList<>();
    public int solution(String numbers) {
        arr = numbers.split("");
        flag = new boolean[arr.length];
        result = new String[arr.length];
        
        dfs(0);
        for(int i = 0; i < list.size(); i++)
        System.out.println(list.get(i));
        return list.size();
    }
    private static void dfs(int num){
        if(num != 0){
            String tmp = "";
            for(int i = 0; i < num; i++)
                tmp += result[i];
            int i = Integer.parseInt(tmp);
            if(isCheck(i)) {
                if(isPrime(i)){
                    list.add(i);
                }
            }
                
        }
        if(num == arr.length) return; 
        for(int i = 0 ; i < arr.length; i++){
            if(!flag[i]){
                flag[i] = true;
                result[num] = arr[i];
                dfs(num + 1);
                flag[i] = false;
            }
        }
    }
    
    //중복 체크
    private static boolean isCheck(int num){
        for(int i : list){
            if(i == num) return false;
        }
        return true;
    }
    
    //소수 판단
    private static boolean isPrime(int num){
        if(num == 1 || num == 0) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}