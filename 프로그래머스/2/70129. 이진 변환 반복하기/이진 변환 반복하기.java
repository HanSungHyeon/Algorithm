import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] ans = new int[2];
        
        while(!s.equals("1")) {
            int len = s.length();
            s = s.replaceAll("0","");
            ans[1] += (len - s.length());
            s = Integer.toBinaryString(s.length());
            ans[0]++;
        }
        return ans;
    }
}