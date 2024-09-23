import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        return twoPointer(sequence, k);
    }
    
    static int[] twoPointer(int[] arr, int k) {
        int s = 0;
        int e = 0;
        int sum = arr[s];
        int[] ans = {0, arr.length - 1};
        
        while(s <= e && e < arr.length) {
            if(sum >= k) {
                if(sum == k && isShort(ans, s, e)) {
                    ans[0] = s;
                    ans[1] = e;
                }
                sum -= arr[s];
                s++;
            } else if(sum < k) {
                e++;
                if(e >= arr.length) break;
                sum += arr[e];
            }
        }
        return ans;
    }
    //더 짧은 길이
    //앞에서부터 탐색하기 때문에 같은 길이는 신경쓰지 않음
    //먼저 갱신되면 그만임
    static boolean isShort(int[] ans, int s, int e) {
        return ans[1] - ans[0] > e - s; 
    }
}