/*
2명이상 주문한 요리
course에 맞춰서 가장 많이 주문된 요리
조합
손님이 주문한 단품메뉴 조합에서 나올 수 있는 조합을 체크
xw = wx
이러면 처음에 정렬 해야함
*/

import java.io.*;
import java.util.*;

class Solution {
    static char[] cook;
    static char[] pick;
    static int max = 0;
    static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        for(int c : course) {
            max = 0;
            map = new HashMap<>();
            for(String order : orders) {
                cook = order.toCharArray();
                pick = new char[c];
                
                Arrays.sort(cook);
                
                if(cook.length < c) continue;
                    comb(0,0,c);
                
            }
            for(String key : map.keySet()) {
                int count = map.get(key);

                if(max == count && count >= 2) list.add(key);
            }
        }
        
        list.sort((o1,o2) -> o1.compareTo(o2));
        
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    static void comb(int start, int count, int course) {
        if(count == course) {
            String str = "";
            for(int i = 0; i < course; i++) {
                str += pick[i];
            }
            
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
            return;
        }
        
        for(int i = start; i < cook.length; i++) {
            pick[count] = cook[i];
            comb(i + 1, count + 1, course);
        }   
    }
}