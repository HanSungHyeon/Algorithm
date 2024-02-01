import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = times[times.length - 1] * (long)n;
        long ans = binarySearch(start, end, times, n);
        return ans;
    }
    
    static long binarySearch(long start, long end, int[] times, int n) {
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long count = 0;
            for(int i : times) {
                count += (mid / i);
            }
            
            if(count >= n) {
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return start;
    }
}