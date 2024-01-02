import java.io.*;
import java.util.*;

class Solution {
    public static class Node {
        int p, t;
        
        public Node(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }
    public static Stack<Node> stack = new Stack<>();
    
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            if(stack.isEmpty()){
                insert(prices[i],i);
                continue;
            } 
            
            if(stack.peek().p > prices[i]) {
                down(prices[i], i, ans);
            }
            insert(prices[i], i);
        }
        
        for(Node n : stack) {
            ans[n.t] = prices.length - 1 - n.t;
        }
        return ans;
    }
    
    public static void insert(int p, int t) {
        stack.push(new Node(p,t));
    }
    
    public static void down(int price, int time, int[] ans) {
        int size = stack.size();
        
        for(int i = 0; i < size; i++) {
            if(stack.peek().p > price) {
                Node n = stack.pop();
                ans[n.t] = time - n.t;
            }
            else return;
        }
    }
}