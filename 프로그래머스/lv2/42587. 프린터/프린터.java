import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i,priorities[i]}); //{문서초기위치, 중요도}
        }
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            boolean flag = true; //중요도가 가장 큰 지
            
            for(int[] ints : q){
                if(temp[1] < ints[1]){ //자신보다 중요도가 큰 요소가 있다면 맨 뒤로
                    q.add(temp);
                    flag = false;   //자신이 젤 크지 않기 때문에 false;
                    break;
                }
            }
            if(!flag) continue; //중요도가 젤 크지 않으면 while문 다시
            
            count++;
            
            if(temp[0] == location) break; //인쇄된 문서의 초기위치가 location과 같을 때 while종료
        }
        
        return count;
    }
}