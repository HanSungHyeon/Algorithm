import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer,Double> map = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
            map.put(i,0.0);
        }
        
        for(int i = 0; i < stages.length; i++) {
            if(map.get(stages[i]) == null) continue;
            if(map.get(stages[i]) != 0) continue;
            int t = 0;
            int f = 0;
            
            for(int j = 0; j < stages.length; j++) {
                if(stages[i] == stages[j]) {
                    t++;
                    f++;
                }
                if(stages[i] < stages[j]) t++;
            }
            map.put(stages[i], (double)f / t);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}