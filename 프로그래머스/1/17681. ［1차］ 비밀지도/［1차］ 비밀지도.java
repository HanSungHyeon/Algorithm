import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        
        for(int i = 0; i < n; i++) {
            String str1 = toBinary(arr1[i], n);
            String str2 = toBinary(arr2[i], n);
            String str = "";
            
            for(int j = 0; j < n; j++) {
                if(str1.charAt(j) == '1' || str2.charAt(j) == '1'){
                    str += "#";
                }
                else str += " ";
            }
            ans[i] = str;
        }
        return ans;
    }
    
    //이진수로 변환 후 가공
    public static String toBinary(int num,int n) {
        String str = Integer.toBinaryString(num);
        
        while(str.length() != n) {
            str = "0" + str;
        }
        
        return str;
    }
}