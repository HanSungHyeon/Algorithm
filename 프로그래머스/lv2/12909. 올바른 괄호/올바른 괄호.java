import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
       Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (queue.isEmpty()) queue.add(s.charAt(i));

            else if (queue.peek().equals('(') && s.charAt(i) == ')') queue.poll();

            else queue.add(s.charAt(i));
        }
        
        if(queue.isEmpty()) return true;
        
        return false;
    }
}