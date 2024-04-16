/*
스택
*/

import java.io.*;
import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty()) stack.push(c);
            
            else if(stack.peek() == c) stack.pop();
            
            else stack.push(c);
        }
        
        if(stack.isEmpty()) answer = 1;
        
        return answer;
    }
}