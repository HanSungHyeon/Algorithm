import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        int x, y, d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static String[][] arr;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
    static int n, m;
    static int rx, ry;
    static boolean[][] flag;
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        arr = new String[n][m];
        flag = new boolean[n][m];
        
        for(int i = 0; i < board.length; i++) {
            arr[i] = board[i].split("");
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j].equals("R")) {
                    rx = i;
                    ry = j;
                }
            }
        }
        int ans = bfs(rx,ry);
        return ans;
    }
    static int bfs(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx,sy,0));
        flag[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int d = q.peek().d;
            q.poll();
            
            if(arr[x][y].equals("G")) return d;
                            
            //이동
            for(int i = 0; i < delta.length; i++) {
                int dx = x + delta[i][0];
                int dy = y + delta[i][1];
                
                while(true) {
                    if(dx < 0 || dx >= n || dy < 0 || dy >= m || arr[dx][dy].equals("D")) {
                        dx -= delta[i][0];
                        dy -= delta[i][1];
                        break;
                    }
                    dx += delta[i][0];
                    dy += delta[i][1];
                }
                if(!flag[dx][dy]) {
                    q.add(new Node(dx,dy, d + 1));
                    flag[dx][dy] = true;
                }
            }
        }
        return -1;
    }
}