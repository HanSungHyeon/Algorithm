import java.io.*;
import java.util.*;

class Solution {
    static boolean[] prime;
    static int[] pick;
    static int ans = 0;
    public int solution(int[] nums) {
        prime = new boolean[1000 * 50];
        pick = new int[3];
        prime();
        combination(0,0,nums);
        return ans;
    }
    
    static void combination(int start, int count, int[] nums) {
        if(count == 3) {
            int tmp = 0;
            for(int i : pick) tmp += i;

            if(prime[tmp]) ans++;
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            pick[count] = nums[i];
            combination(i + 1, count + 1, nums);
        }
    }
    
    static void prime() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 2; i <= Math.sqrt(1000 * 50); i++) {
            if(prime[i]) {
                for(int j = i * i; j < 1000 * 50; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}