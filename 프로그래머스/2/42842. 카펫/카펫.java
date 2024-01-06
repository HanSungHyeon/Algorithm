import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] ans = new int[2];
        for(int r = 1; r <= sum; r++) {
            if(sum % r != 0) continue;
            
            int c = sum / r;
            
            if((r * 2) + (c * 2) - 4 == brown) {
                ans[0] = r;
                ans[1] = c;
            }
        }
        return ans;
    }
}