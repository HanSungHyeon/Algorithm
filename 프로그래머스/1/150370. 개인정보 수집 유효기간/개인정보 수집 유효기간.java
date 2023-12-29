import java.io.*;
import java.util.*;

//전부 (일)로 변환해서 계산
class Solution {
    public static HashMap<String,Integer> map = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        for(String t : terms) {
            map.put(t.substring(0,1), Integer.parseInt(t.substring(2,t.length())));
        }
        
        int todayNum = getDay(today);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            int m = map.get(arr[arr.length - 1]);
            
            if(getDay(arr[0]) + (m * 28) <= todayNum) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    //연 월 일 변환 후 가져오기
    public static int getDay(String date) {
        String[] arr = date.split("\\.");
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        
        return d + (m * 28) + (y * 12 * 28);
    }
}