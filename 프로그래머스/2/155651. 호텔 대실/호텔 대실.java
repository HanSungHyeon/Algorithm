/*
호텔 최소 객실만 사용
퇴실 시간 기준 + 10분
정렬
["14:10", "19:20"]
["14:20", "15:20"]
["15:00", "17:00"]
["16:40", "18:20"]
["18:20", "21:20"]
아이 왜또 String이야
걍 리플레이스 ㄱㄱ
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Time {
        int s, e;
        public Time (int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Time> list = new ArrayList<>();
        
        for(int i = 0; i < book_time.length; i++) {
            int s = Integer.parseInt(book_time[i][0].replace(":", ""));
            int e = Integer.parseInt(book_time[i][1].replace(":", "")) + 10;
            
            if(e % 100 >= 60) {
                //s += 100 - 60;
                e += 40;
            }
            list.add(new Time(s,e));
        }
        
        list.sort((o1,o2) -> {
            if(o1.s == o2.s)
                return o1.e - o2.e;
            return o1.s - o2.s;
        });
        
        PriorityQueue<Time> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        
        for(Time t : list) {
            if(pq.isEmpty()) pq.add(t);
            
            else {
                Time room = pq.peek();
                if(room.e > t.s) pq.add(t);
                else {
                    pq.poll();
                    pq.add(t);
                }
            }
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}