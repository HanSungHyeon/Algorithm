import java.io.*;
import java.util.*;

class Solution {
    public static HashMap<String, Set<String>> map = new HashMap<>();
    public static HashMap<String, Integer> count = new HashMap<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        for(String id : id_list) {
            Set<String> set = new HashSet<>();
            map.put(id, set);
            count.put(id,0);
        }
        
        for(String s : report) {
            String[] arr = s.split(" ");
            map.get(arr[0]).add(arr[1]);
        }
        
        //신고 당한 횟수 세팅
        map.forEach((s, strings) -> {
            strings.forEach(v -> count.put(v, count.get(v) + 1));
        });
        
        List<String> list = new ArrayList<>();
        for(String s : count.keySet()) {
            if(count.get(s) >= k) {
                list.add(s);        
            }
        }
        
        int[] ans = new int[id_list.length];
        
        for(String name : list) {
            for(int i = 0; i < id_list.length; i++) {
                for(String v : map.get(id_list[i])) {
                    if(v.equals(name)) 
                        ans[i]++;
                }
            }
        }
        return ans;
        
    }
}