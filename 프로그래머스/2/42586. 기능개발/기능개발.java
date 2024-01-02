import java.io.*;
import java.util.*;

class Solution {
    public static Queue<Integer> p = new LinkedList<>();
    public static Queue<Integer> s = new LinkedList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i : progresses) p.add(i);
        for(int i : speeds ) s.add(i);
        
        while(!p.isEmpty()) {
            int tmp = 100 - p.peek();
            int day = 0;
            int size = p.size();
            if(tmp % s.peek() == 0) day = tmp / s.peek();
            else day = tmp / s.peek() + 1;
            
            insert(size, day);
            if(p.peek() >= 100) ans.add(remove(size));
            
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void insert (int size, int day) {
        for(int i = 0; i < size; i++) {
            int pNode = p.poll();
            int sNode = s.poll();
            
            p.add((sNode * day) + pNode);
            s.add(sNode);
        }
    }
    
    public static int remove (int size) {
        int remove = 0;
        for(int i = 0; i < size; i++) {
            int pNode = p.peek();
            int sNode = s.peek();
            
            if(pNode >= 100){
                remove++;
                p.poll();
                s.poll();
            } 
            else return remove;
        }
        return remove;
    }
}