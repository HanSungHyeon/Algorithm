/*

*/

import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> map1 = new HashMap<>();
    static HashMap<String, Integer> map2 = new HashMap<>();
    
    public int solution(String str1, String str2) {
        //map 세팅
        init(str1, map1);
        init(str2, map2);
        
        //교집합
        double a = inter();
        //합집합
        double b = union();
        
        int answer = 65536;
        
        if(a != 0 || b != 0) {
            System.out.println("a : " + a + " b : " + b);
            double tmp = a / b * 65536;
            
            if(Double.isNaN(tmp)) answer = 0;
            else answer = (int)tmp;
        }
        
        return answer;
    }
    
    static double inter(){
        double num = 0;
        for(String key : map1.keySet()) {
            int v2 = map2.getOrDefault(key, 0);
            
            if(v2 != 0) {
                int v1 = map1.get(key);
                num += Math.min(v1,v2);
            }
        }
        return num;
    }
    
    static double union() {
        double num = 0;
        for(String key : map1.keySet()) {
            int v2 = map2.getOrDefault(key, 0);
            int v1 = map1.get(key);
            
            if(v2 == 0) num += v1;
            
            else {    
                num += Math.max(v1, v2);
                map2.remove(key);
            }
        }
        
        for(String key : map2.keySet()) {
            num += map2.get(key);
        }
        return num;
    }
    
    static void init(String str, HashMap<String, Integer> map) {
        str = str.toUpperCase();
        
        for(int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            if(isCheck(c1) && isCheck(c2)) {
                String key = Character.toString(c1) + Character.toString(c2);
                
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
    }
    
    static boolean isCheck(char c) {
        return c >= 65 && c <= 90;
    }
}