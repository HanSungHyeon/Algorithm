import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        String str = "";
        int[] arr = new int[3];
        int idx = 0;
        for(int i = 0 ; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            //점수일 경우
            if(c >= '0' && c <= '9') 
                str += c;
            
            //보너스
            if(c >= 'A' && c <= 'Z') {
                int num = Integer.parseInt(str);
                switch(c) {
                    case 'S' : arr[idx] = num;
                        break;
                    case 'D' : arr[idx] = num * num;
                        break;
                    case 'T' : arr[idx] = num * num * num;
                }
                idx++;
                str = "";
            }
                
            //옵션
            if(c == '*' || c == '#') {
                if(idx >= 2 && c == '*') arr[idx - 2] = option(arr[idx - 2], c);
                
                arr[idx - 1] = option(arr[idx - 1], c);
            }
        }        
        return Arrays.stream(arr).sum();
    }
    
    public static int option (int num, char op) {
        switch(op) {
            case '*': return num * 2;
            case '#': return num * (-1);
        }
        return num;
    }
}