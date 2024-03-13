/*
구명보트는 무조건 2명만 탈 수 있음
*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i : people) dq.add(i);
        
        while(!dq.isEmpty()) {
            int big = dq.removeLast();
            
            if(dq.size() >= 1 && limit - big >= dq.peekFirst()) {
                dq.removeFirst();
            }
            answer++;
        }
        
        return answer;
    }
}