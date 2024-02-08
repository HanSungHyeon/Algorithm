import java.io.*;
import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        int idx = 0;
        for(int[] arr : list) {
            answer[idx][0] = arr[0];
            answer[idx][1] = arr[1];
            idx++;
        }
        return answer;
    }
    static void hanoi(int n, int start, int mid, int end) {
        if(n == 0) return;
        
        hanoi(n - 1, start, end, mid);
        list.add(new int[]{start, end});
        hanoi(n - 1, mid, start, end);
    }
}