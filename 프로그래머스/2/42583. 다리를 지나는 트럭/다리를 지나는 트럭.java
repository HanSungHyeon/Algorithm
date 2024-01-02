import java.io.*;
import java.util.*;

//1. 시간 증가
//2. 다리 큐 이동
//3. 다리 큐 무게, 대기 큐 맨 앞 무게 비교
//4 - 1. 올라갈 수 있다면 대기 큐 poll -> 다리큐 삽입
//4 - 2. 올라갈 수 없다면 대기 큐 유지 -> 다리큐 0 삽입
//5. 반복
//유의 -> 대기 큐 사이즈 = 0 -> 반복문 break -> time + 다리큐 사이즈
class Solution {
    public static Queue<Integer> bq = new LinkedList<>();
    public static Queue<Integer> tq = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        for(int i = 0; i < bridge_length; i++ ) bq.add(0);
        for(int i : truck_weights) tq.add(i);
        
        while(!tq.isEmpty()) {
            time++;
            bq.poll();
            
            //다리 무게 초과하지 않는다면
            if(bq.stream().mapToInt(i -> i).sum() + tq.peek() <= weight) bq.add(tq.poll());
            else bq.add(0);
        }
        return time + bq.size();
    }
}