import java.io.*;
import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    public int solution(int[] order) {
        int answer = 0;
        
        int idx = 0;
        int cur = 1;
        while(idx != order.length) {
            int o = order[idx];
            /*
            (2,2) (3,3) (4,4) (5,5) (1)
            
            */
            if(o == cur) {
                answer++;
                idx++;
                cur++;
            }
            
            else if(cur < o) {
                stack.push(cur);
                cur++;
            }
            
            else {
                if(stack.peek() == o) {
                    answer++;
                    stack.pop();
                    idx++;
                }
                else break;
            }
        }
        return answer;
    }
}