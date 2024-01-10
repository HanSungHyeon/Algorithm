import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(String s : operations) {
            StringTokenizer st = new StringTokenizer(s, " ");
            String code = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(code.equals("I")) {
                min.add(num);
                max.add(num);
            }
            else if(!min.isEmpty()){
                if(num < 0) {
                    int tmp = min.poll();
                    max.remove(tmp);
                }
                else {
                    int tmp = max.poll();
                    min.remove(tmp);
                }
            }
        }
        int[] ans = new int[2];
        ans[1] = min.isEmpty() ? 0 : min.poll();
        ans[0] = max.isEmpty() ? 0 : max.poll();
        
        return ans;
    }
}