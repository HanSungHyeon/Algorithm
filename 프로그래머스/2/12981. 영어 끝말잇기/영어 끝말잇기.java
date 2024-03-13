/*
배열 순회
앞 단어의 맨 뒤와 현재 단어의 맨 앞이 일치하는 지 확인
-> 일치하지 않으면 아웃
-> 과거에 이미 나온 이력이 있는 단어면 아웃
--> map 사용
*/
import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String,Boolean> map = new HashMap<>();
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        map.put(words[0], true);
        
        for(int i = 1; i < words.length; i++) {
            String cur = words[i];
            
            if(isDuplication(cur) || !isCheck(words[i - 1], cur)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }   
            map.put(cur, true);
        }
        return answer;
    }
    //중복 단어 체크
    static boolean isDuplication(String word){
        return map.getOrDefault(word, false);
    }
    
    //앞 단어와 이어질 수 있는 지 체크
    static boolean isCheck(String prev, String cur) {
        return prev.charAt(prev.length() - 1) == cur.charAt(0);
    }
}