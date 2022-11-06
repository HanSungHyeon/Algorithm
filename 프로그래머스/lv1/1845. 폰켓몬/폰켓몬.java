import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums)
            map.put(i,map.getOrDefault(i,0) + 1);
        
        if(map.size() >= nums.length / 2)
            return nums.length / 2;
        
        else
            return map.size();
    }
}