import java.io.*;
import java.util.*;

class Solution {
    public static HashMap<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        for(int i = 0; i < survey.length; i++) {
            check(survey[i], choices[i]);
        }
        
        int idx = 1;
        char c1 = '1';
        char c2 = '2';
        String ans = "";
        
        ans = set('R','T',ans);
        ans = set('C','F',ans);
        ans = set('J','M',ans);
        ans = set('A','N',ans);
        
        return ans;
    }
    
    //성격 유형 세팅
    public static String set (char c1, char c2, String ans) {
        if(map.get(c1) > map.get(c2)) return ans += c1;
        else if (map.get(c1) < map.get(c2)) return ans += c2;
        else {
            if(c1 > c2) return ans += c2;
            else return ans += c1;
        }
    }
    
    //점수 넣기
    public static void score (char c, int s) {
        map.put(c, map.get(c) + s);
    }
    
    //답변 고르기
    public static void check(String s, int num) {
        if(num == 4) return;
        
        char s1 = s.charAt(0);
        char s2 = s.charAt(1);
        
        switch(num) {
            case 1: score(s1, 3); break;
            case 2: score(s1, 2); break;                
            case 3: score(s1, 1); break;
            case 5: score(s2, 1); break;
            case 6: score(s2, 2); break; 
            case 7: score(s2, 3); break;
            default : break;
        }
    }
}