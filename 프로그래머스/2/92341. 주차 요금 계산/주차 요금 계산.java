//전부 분으로 치환해서 작업 진행
//180분 이하 -> 5000원
//180분 초과 -> 10분당 600
//나누어 떨어지지 않으면 그냥 올림 -> math.ceil
//map 2개 -> 출차 기록 모아두는 거
//누적 시간 모아두는 거
//차 번호 가장 낮은 작은 친구부터 출력
//입차만 하고 출차 없을 수 있음
import java.io.*;
import java.util.*;

class Solution {
    static TreeMap<String, Integer> logs = new TreeMap<>();
    static TreeMap<String, Integer> time = new TreeMap<>();
    static final int endTime = (23 * 60) + 59;
    
    public int[] solution(int[] fees, String[] records) {
        for(int i = 0 ; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]," ");
            String[] arr = st.nextToken().split(":");
            int t = (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
            String carNum = st.nextToken();
            String l = st.nextToken();
            
            if(l.equals("IN")) {
                logs.put(carNum, t);
                
            }
            else {
                time.put(carNum,t - logs.get(carNum) + time.getOrDefault(carNum, 0));
                logs.remove(carNum);
            }
        }
        
        //출차 기록 없는 애들 23:59에 강제 출차
        for(String key : logs.keySet()) {
            int t = endTime - logs.get(key);
            time.put(key, time.getOrDefault(key, 0) + t);
        }
        
        //요금 계산
        List<Integer> list = new ArrayList<>();
        for(String key : time.keySet()) {
            int t = time.get(key);
            int fee = fees[1];
            if(t <= fees[0]) list.add(fee);
            
            else {
                t -= fees[0];
                fee += (int)Math.ceil((double)t / fees[2]) * fees[3];
                list.add(fee);
            }
        }
        //매핑
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}