import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        String result = "";

        for(String s : participant)
            map.put(s, map.getOrDefault(s,0) + 1);

        for(String s : completion)
            map.put(s, map.get(s) + 1);

        for (String s : map.keySet()) {
            if(map.get(s) % 2 != 0) {
                result = s;
                break;
            }
        }
        return result;
    }
}
