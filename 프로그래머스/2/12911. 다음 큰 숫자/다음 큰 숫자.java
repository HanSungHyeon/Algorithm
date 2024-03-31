/*
n을 2진수로 변형
숫자 하나씩 늘려가면서 2진수 변형해서 체크
*/

import java.io.*;
import java.util.*;

class Solution {
    static int ans = 0, count = 0;
    public int solution(int n) {
        String b = Integer.toBinaryString(n);
        for(int i = 0; i < b.length(); i++) {
            if(b.charAt(i) == '1') count++;
        }
        
        while(true) {
            n++;
            if(findNum(n)) break;
            
        }
        return ans;
    }
    static boolean findNum(int n) {
        String binary = Integer.toBinaryString(n);
        
        int c = 0;
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') c++;
        }
        
        if(c != count) return false;
        
        ans = n;
        return true;
    }
}