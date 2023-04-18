import java.io.*;
import java.util.*;

//문자 하나씩 연결하면서 재귀
//문자 하나 연결했을 때 count + 1
//일치하는 문자 완성했으면 더 이상 재귀 태울 필요 없음
// -> 빵집마냥 flag 써서 걍 나옴
//문자 최대 길이 5 -> 만든 문자열 5면 뒤로 돌림
//재귀에서 나오면 맨 마지막 문자 지우고 다시

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static String[] arr = {"A","E","I","O","U"};
    static boolean flag = false;
    
    public int solution(String word) {
        dfs(sb, word);
        return count;
    }
    
    private static void dfs(StringBuilder sb,String word){
        if(sb.toString().equals(word)){
            flag = true;
            return;
        }
        
        if(sb.length() == 5) return;
        
        for(int i = 0; i < 5; i++){
            sb.append(arr[i]);
            count++;
            dfs(sb, word);
            if(flag) return;
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}