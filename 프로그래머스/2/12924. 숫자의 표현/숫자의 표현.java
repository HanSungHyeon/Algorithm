/*
완탐으로 해보쟈
*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <=n; i++) {
            int tmp = i;
            for(int j = i + 1; j <= n; j++) {
                tmp += j;
                if(tmp == n) {
                    answer++;
                    break;
                }
                else if(tmp > n) break;
            }
        }
        
        return answer + 1;
    }
}