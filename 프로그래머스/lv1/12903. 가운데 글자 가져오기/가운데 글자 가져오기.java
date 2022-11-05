import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        if(s.length() % 2 == 0){
            sb.append(s.charAt(s.length() / 2 - 1)).append(s.charAt(s.length() / 2));    
        }
        else
            sb.append(s.charAt(s.length() / 2));
        
        return sb.toString();
    }
}