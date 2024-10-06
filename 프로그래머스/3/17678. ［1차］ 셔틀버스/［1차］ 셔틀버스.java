/*
1시간 = 60분 = 1 * 60
디지털 시간으로 변환
1시간 = (60분 / 60)
1분 = (100분 % 60) = 40

9시에는 무조건 한 번 온다고 봐야하나?
*/

import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int con = 0;
        
        for(String time : timetable) {
            String[] arr = time.split(":");
            int hour = Integer.parseInt(arr[0]) * 60;
            int min = Integer.parseInt(arr[1]);
            
            pq.add(hour + min);
        }
        
        int bus = 60 * 9;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                if(pq.isEmpty()) break;
                
                int time = pq.peek();
                
                if(time <= bus) {
                    con = pq.poll() - 1;
                    count++;
                }
            }
            if(count < m) con = bus;
            
            bus += t;
        }
        
        String hour = String.format("%02d", (con / 60));
        String min = String.format("%02d", (con % 60));
        answer = hour + ":" + min;
        return answer;
    }
 
}