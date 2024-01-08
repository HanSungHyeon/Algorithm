import java.io.*;
import java.util.*;

class Solution {
    public static HashMap<Integer, Boolean> map = new HashMap<>();
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = n - lost.length;
        List<Integer> list = new ArrayList<>();

        for(int i : lost) map.put(i, false);
        
        //지가 잃어버리고 지가 가져온 경우 먼저 체크
        for(int i : reserve) {
            if(rent(i)) ans++;
            else list.add(i);
        }
        
        //오름차순 정렬 -> 오름차순되어 입력된다는 보장이 없음
        list.sort((o1, o2) -> o1 - o2);
        
        //빌려주기
        for(int i : list) {
            if(rent(i - 1)) ans++;
            else if (rent(i + 1)) ans++;
        } 
        return ans;
    }
    public static boolean rent(int i) {
        if(map.getOrDefault(i, true) == false) {
            map.remove(i);
            return true;
        }
        return false;
    }
}