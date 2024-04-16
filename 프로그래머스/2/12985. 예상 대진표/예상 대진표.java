/*
(1, 2 승리) -> 1
(3, 4 승리) -> 2
짝수 / 2
*/

import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            answer++;
            if(isCheck(a, b)) {
                break;
            }
            a = nextNum(a);
            b = nextNum(b);
        }
        return answer;
    }
    static boolean isCheck(int a, int b) {
        if(a % 2 == 0) return b + 1 == a;
        else if(b % 2 == 0) return a + 1 == b;
        return a == b;
    }
    
    static int nextNum(int num) {
        //짝수일 때
        if(num % 2 == 0) return num / 2;
        
        return (num + 1) / 2;
    }
}