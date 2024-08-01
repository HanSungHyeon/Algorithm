/*
각 자릿 수의 합
*/
import java.util.*;
import java.io.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n > 0) {
            int tmp = n % 10;
            n /= 10;
            answer += tmp;
        }

        return answer;
    }
}