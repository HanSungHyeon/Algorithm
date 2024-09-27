/*
3차원배열?
[x][y][2]
레버 당긴거 안당긴거 이렇게 하면 안되나??
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int x, y, h,count;
        public Node(int x, int y, int h, int count) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.count = count;
        }
    }
    static String[][] arr;
    static boolean[][][] flag;
    static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(String[] maps) {
        int answer = 0;
        int startx = 0, starty = 0;
        arr = new String[maps.length][maps[0].length()];
        flag = new boolean[maps.length][maps[0].length()][2];
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                arr[i][j] = maps[i].charAt(j) + "";
                if(arr[i][j].equals("S")) {
                    startx = i; starty = j;
                }
            }
        }
        answer = bfs(startx, starty);
        return answer;
    }
    
    static int bfs(int startx, int starty) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startx, starty, 0, 0));
        flag[startx][starty][0] = true;
        
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int h = q.peek().h;
            int count = q.peek().count;
            q.poll();
            
            if(arr[x][y].equals("E") && h == 1) return count;
            
            for(int i = 0; i < delta.length; i++) {
                int dx = x + delta[i][0];
                int dy = y + delta[i][1];
                
                if(dx < 0 || dx >= arr.length || dy < 0 || dy >= arr[0].length || arr[dx][dy].equals("X") || flag[dx][dy][h]) continue;
                
                if(arr[dx][dy].equals("L")) {
                    q.add(new Node(dx,dy,1,count + 1));
                    flag[dx][dy][0] = true;
                    flag[dx][dy][1] = true;
                }
                
                else {
                    q.add(new Node(dx,dy,h,count + 1));
                    flag[dx][dy][h] = true;
                }
            }
        }
        return -1;
    }
}