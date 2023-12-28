import java.io.*;
import java.util.*;

//0의 갯수 확인
//일치하는 갯수 확인

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count0 = 0;
        int t = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                count0++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    t++;
                    break;
                }
            }
        }
        //최고 순위 공식 = 7 - 일치하는 갯수 - 0의 갯수
        //최저 순위 공식 = 7 - 일치하는 갯수
        int[] ans = new int[2];
        ans[0] = 7 - t - count0;
        ans[1] = 7 - t;
        
        for(int i = 0 ; i < 2; i++){
            if(ans[i] == 7) ans[i] = 6;
        }
        
        return ans;
    }
}