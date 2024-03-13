import java.io.*;
import java.util.*;

class Solution{
    public int solution(int []A, int []B){
        int ans = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) {
            ans += (A[i] * B[B.length - (i + 1)]);
        }
        return ans;
    }
}