import java.io.*;
import java.util.*;

class Solution {
    static Queue<Character> q = new LinkedList<>();
    static Stack<Character> stack;
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i< s.length(); i++) {
            q.add(s.charAt(i));
        }
        
        if(rotation()) answer++;
        
        for(int i = 1; i < s.length(); i++) {
            q.add(q.poll());
            if(rotation()) answer++;
        }
        
        return answer;
    }
    static boolean rotation() {
        stack = new Stack();
        
        for(char c : q) {
            if(stack.isEmpty()) stack.push(c);
            
            else if(c == '[' || c == '(' || c == '{') stack.push(c);
            
            else {
                switch(c) {
                    case ']' : {
                        if(stack.peek() == '[') stack.pop();
                        break;
                    }
                    case ')' : {
                        if(stack.peek() == '(') stack.pop();
                        break;
                    }
                    case '}' : {
                        if(stack.peek() == '{') stack.pop();
                        break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}