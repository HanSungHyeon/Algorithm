/*
현재 위치 -> 이동 위치
이동 위치 -> 현재 위치
둘 다 set에 넣고 / 2 하면 될 듯
*/

import java.io.*;
import java.util.*;

class Solution {
    static int cx = 0, cy = 0, nx = 0, ny = 0;
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            char cmd = dirs.charAt(i);
            
            switch(cmd) {
                case 'U' : nx++;
                    break;
                case 'D' : nx--;
                    break;
                case 'L' : ny--;
                    break;
                case 'R' : ny++;
                    break;
            }
            
            if(isCheck()) {
                set.add(""+ cx + cy + " " + nx + ny);
                set.add(""+ nx + ny + " " + cx + cy);
                cx = nx;
                cy = ny;
            }
            nx = cx;
            ny = cy;
        }
        
        return set.size() / 2;
    }
    //좌표 유효성 체크
    static boolean isCheck() {
        return nx <= 5 && nx >= -5 && ny <= 5 && ny >= -5;
    }
}