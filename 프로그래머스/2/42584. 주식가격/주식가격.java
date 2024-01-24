import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        int p, idx;
        public Node(int p, int idx) {
            this.p = p;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        int max = prices.length - 1; 
        Stack<Node> stack = new Stack<>();
        
        
        for(int i = 0; i < prices.length; i++) {
            if(stack.isEmpty()) {
                stack.push(new Node(prices[i], i));
            }
            
            else {
                while(stack.peek().p > prices[i]) {
                    Node node = stack.pop();
                    ans[node.idx] = i - node.idx;
                    
                    if(stack.isEmpty()) break;
                }
                stack.push(new Node(prices[i], i));
            }
        }
        
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            ans[node.idx] = max - node.idx;
        }
        return ans;
    }
}