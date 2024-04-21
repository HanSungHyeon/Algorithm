/*
split -> "{ , }"
그럼 숫자만 나올거임
중복되는 거 전부 제거
남은 숫자가 답
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        String num; int count;
        public Node(String num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public int[] solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = s.split("\"|\\{|\\}|,");
        
        for(String str : arr) {
            if(str.equals("")) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        int[] answer = new int[map.size()];
        
        List<Node> list = new ArrayList<>();
        for(String key : map.keySet()) {
            list.add(new Node(key, map.get(key)));
        }
        
        list.sort((o1,o2) -> o2.count - o1.count);
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i).num);
        }
        return answer;
    }
}