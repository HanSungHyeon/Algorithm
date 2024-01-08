import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int idx = 0;
        
        for(int i = 0; i < len; i++) {
            char word = '0';

            for(int j = idx; j <= number.length() - len + i; j++) {
                if(word < number.charAt(j) || word == '0') {
                    word = number.charAt(j);
                    idx = j + 1;
                }
            }
            sb.append(word);
        }
        return sb.toString();
    }
}

// 4 1 7 7 2 5 2 8 4 1
// 0 1 2 3 4 5 6 7 8 9
/// 10 - 6 = 4
/// 10 - 5 = 5
// 6자리니까 뒤에 5자리 킾하고 앞에 애들 중에 최댓값 비교
// 최대 중에서는 같은 놈이라면 그냥 넘겨버림
// 다음 반복에서는 4자리 킾하고 앞에 애들 중에 최댓값 비교
// 이미 고른 놈 다음꺼로 진행