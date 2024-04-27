
import java.io.*;
import java.util.*;

class Solution {
    static HashMap<Character, Integer> map = new HashMap<>();
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i + 1);
        }
        
        
        for(String str : skill_trees) {
            if(isCheck(str)) answer++;
            
        }
        return answer;
    }
    
    static boolean isCheck(String str) {
        int cur = 1;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = map.getOrDefault(c, 0);
            
            if(cur == num) cur++;
            
            else if(num > cur) return false;
        }
        return true;
    }
}