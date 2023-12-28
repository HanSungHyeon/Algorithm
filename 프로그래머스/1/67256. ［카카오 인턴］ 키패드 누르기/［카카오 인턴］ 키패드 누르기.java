import java.io.*;
import java.util.*;

// 1, 4, 7의 경우 왼손이 무조건 해당 번호로 이동
// 3, 6, 9의 경우 오른손이 무조건 해당 번호로 이동
// 2, 5, 8, 0의 경우 사방탐색 진행 후 거리가 더 가까운 손이 이동
// 어떤 손이 이동했는지 String 이어붙이기
class Solution {
    public static int lx = 3, ly = 0, rx = 3, ry = 2; 
    public static StringBuilder sb = new StringBuilder();
    public static int[][] phone = {{3,1}, {0,0}, {0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
    public String solution(int[] numbers, String hand) {
        for(int num : numbers) {
            int x = phone[num][0];    
            int y = phone[num][1];
            
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                move(x,y,"L");
            }
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                move(x,y,"R");
            }
            else {
                check(x,y,hand);
            }
        }
        
        return sb.toString();
    }
    
    //손 이동
    public static void move(int x, int y, String mh) {
        if(mh.equals("L")){
            lx = x;
            ly = y;
        }
        else {
            rx = x;
            ry = y;
        }
    }
    
    //거리 확인
    public static void check(int x, int y, String hand) {
        int ld = Math.abs(lx - x) + Math.abs(ly - y);
        int rd = Math.abs(rx - x) + Math.abs(ry - y);
        
        if(ld == rd) {
            if(hand.equals("right")) {
                rx = x;
                ry = y;
                sb.append("R");
            }
            else {
                lx = x;
                ly = y;
                sb.append("L");
            }
        }
        else if (ld > rd) {
            rx = x;
            ry = y;
            sb.append("R");
        }
        else {
            lx = x;
            ly = y;
            sb.append("L");
        }
    }
}