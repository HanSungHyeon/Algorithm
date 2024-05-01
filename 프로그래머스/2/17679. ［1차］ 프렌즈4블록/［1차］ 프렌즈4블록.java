/*
현재 기준 우, 하, 우측하단 4개가 전부 같으면 제거
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
    static char[][] arr;
    static boolean[][] flag;
    static Queue<Node> q = new LinkedList<>();
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][n];
        flag = new boolean[m][n];
        for(int i = 0; i < board.length; i++) {
            arr[i] = board[i].toCharArray();
        }
        
        while(true) {
            find(m,n);
            int num = remove();
            if(num == 0) break;
            answer += num;
            for(int i = 0; i < n; i++) {
                down(i,m);
            }
        }
        
        return answer;
    }
    
    //지울 수 있는 것들 확인
    static void find(int m, int n) {
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                char c = arr[i][j];
                if(c == '#') continue;
                
                if(c == arr[i + 1][j] && c == arr[i][j + 1] && c == arr[i + 1][j + 1]) {
                    q.add(new Node(i, j));
                    q.add(new Node(i + 1, j));
                    q.add(new Node(i, j + 1));
                    q.add(new Node(i + 1, j + 1));
                }
            }
        }
    }
    //제거
    static int remove() {
        int num = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(arr[node.x][node.y] != '#') {
                arr[node.x][node.y] = '#';    
                num++;
            }
        }
        return num;
    }
    //내리기
    static void down(int col, int m) {
        for(int i = m - 1; i >= 0; i--) {
            if(arr[i][col] == '#') {
                for(int j = i - 1; j >= 0; j--) {
                    if(arr[j][col] != '#') {
                        char tmp = arr[i][col];
                        arr[i][col] = arr[j][col];
                        arr[j][col] = tmp;
                        break;
                    }
                }
            }
        }
        
    }
}