import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
       int count = 0;
        
        if(s.charAt(0) == ')') return false;
        
        for(int i =0 ; i < s.length(); i++){
            if(s.charAt(i) == '(') count++;
            
            else count--;
            
            if(count < 0) return false;
            
            
        }
        
        if(count == 0) return true;
        return false;
    }
}