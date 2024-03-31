/*
완탐
빈병 / a = 콜라
콜라 마심 = 새로 생긴 빈병
콜라가 홀수 : 
/ a의 갯수만큼만 마시고 남은거는 킵
병 < a 까지 반복
*/
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;
        
        while(n >= a) {
            int give = (n / a) * a;
            int take = (give / a) * b;
            ans += take;
            n = n - give + take;
        }
        return ans;
    }
}