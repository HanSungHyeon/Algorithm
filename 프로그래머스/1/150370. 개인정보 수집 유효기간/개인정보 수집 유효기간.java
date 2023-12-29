import java.io.*;
import java.util.*;

class Solution {
    public static HashMap<String, Integer> map = new HashMap();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for(String term : terms) {
            map.put(term.substring(0,1), Integer.parseInt(term.substring(2, term.length())));    
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            if(cal(privacies[i],today)) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    //약관 확인 후 날짜 계산
    public static boolean cal (String p, String today) {
        String[] arr = p.split("[.\\s]");

        int i = map.get(arr[arr.length - 1]);        
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        
        // 13 + 5 = 18 -> 1y 6m
        // 21 + 5 = 27 -> 2y 3m
        // 100 + 5 = 105 = 8y 9m
        
        if(i + m > 12) {
            y += (i + m) / 12;
            m = (i + m) % 12;
            
            if(m == 0) {
                y--;
                m = 12;
            }
        }
        else 
            m += i;
        
        System.out.println("y : " + y + " m : " + m);
        return isExp(y,m,d,today);
    }
    
    //날짜 비교
    public static boolean isExp(int y, int m, int d, String today) {
        int[] arr = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        
        if(arr[0] > y) return true;
        if(arr[0] < y) return false;
        else {
            if(arr[1] > m) return true;
            if(arr[1] < m) return false;
            else {
                if(arr[2] >= d) return true;
            }
        }
        return false;
    }
}