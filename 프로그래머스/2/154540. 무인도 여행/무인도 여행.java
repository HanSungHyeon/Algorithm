/*
x = 바다
숫자 무인도
연결된 땅은 하나의 무인도
숫자 = 식량의 수
모두 합한 값 = 며칠
섬에서 최대 며칠씩 머무를 수 있는 지 알아보기
각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담으려 함
만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담음
100 100
완탐
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static String[][] arr;
    static boolean[][] flag;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int[] solution(String[] maps) {
        arr = new String[maps.length][maps[0].length()];
        flag = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            arr[i] = maps[i].split("");
        }
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(!flag[i][j] && !arr[i][j].equals("X")) {
                    list.add(bfs(i,j));
                }
            }
        }
        
        list.sort((o1,o2) -> o1 - o2);
        int[] ans;
        
        if(list.size() == 0) {
            ans = new int[]{-1};
        } else {
            ans = new int[list.size()];
            int idx = 0;
            
            for(int num : list) ans[idx++] = num;
        }
        
        return ans;
    }
    
    static int bfs(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        flag[sx][sy] = true;
        int sum = 0;
        
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            sum += Integer.parseInt(arr[x][y]);
            q.poll();
            
            for(int i = 0; i < delta.length; i++) {
                int dx = x + delta[i][0];
                int dy = y + delta[i][1];
                
                if(dx < 0 || dx >= arr.length || dy < 0 || dy >= arr[0].length || flag[dx][dy] || arr[dx][dy].equals("X"))
                    continue;
                
                q.add(new Node(dx, dy));
                flag[dx][dy] = true;
            }
        }
        return sum;
    }
}