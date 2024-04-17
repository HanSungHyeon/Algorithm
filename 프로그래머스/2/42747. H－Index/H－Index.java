/*
h번 이상 나머지는 h번 이하
ex)
1 : 1번 이상 인용 1번 이하 인용
2 : 2번 이상 인용 2번 이하 인용
최대 인용 횟수는 원소의 최대값
완탐을 하게 된다면?
*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int max = Arrays.stream(citations).max().getAsInt();
        
        int idx = 0;
        for(int i = 0; i <= max ; i++) {
            int a = 0, b = 0;
            for(int j = 0; j < citations.length; j++) {
                if(citations[j] >= i) a++;
                if(citations[j] <= i) b++;
                
                if(a >= i && b <= i) {
                    idx = i;
                    break;
                }
            }
        }
        
        return idx;
    }
}