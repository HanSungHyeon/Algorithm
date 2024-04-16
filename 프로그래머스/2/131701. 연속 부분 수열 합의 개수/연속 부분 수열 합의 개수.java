/*
0 = 7
1 = 9
2 = 1
3 = 1
4 = 4
///////
5 = 7
6 = 9
5로 나눈 나머지
6 % 5 = 1
7 % 5 = 2
*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(sol(i, j, elements));
            }
        }
        
        return set.size();
    }
    
    static int sol(int len, int start, int[] elements) {
        int count = 0;
        int sum = 0;
        
        while(count != len) {
            sum += elements[start % elements.length];
            start++;
            count++;
        }
        return sum;
    }
}