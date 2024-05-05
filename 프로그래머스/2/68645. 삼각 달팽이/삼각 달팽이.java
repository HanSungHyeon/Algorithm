/*
하 -> 우 -> 상 -> 좌 반복
하 : [row + 1][col]
우 : [row][col + 1]
상 : [row -1][col - 1]
좌 : [row][col - 1]
*/

import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int[][] arr;
    static int max, cur = 1;;
    public int[] solution(int n) {
        arr = new int[n][n];
        
        for(int i = 1; i <= n; i++) {
            max += i;
        }
        Node node = new Node(-1,0);
        while(cur <= max) {
            
            //아래
            node = down(node.row + 1, node.col);
            //오른쪽
            node = right(node.row, node.col + 1);
            //위
            node = up(node.row - 1, node.col - 1);
            //왼쪽
            node = left(node.row, node.col - 1);
        }
        int[] answer = new int[max];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
    
    static boolean isCheck(int row, int col) {
        if(row < 0 || row >= arr.length || col < 0 || col >= arr.length) return false;
        
        return arr[row][col] == 0;
    }
    static Node down(int row, int col) {
        while(true) {
            if(!isCheck(row, col)) break;
            arr[row++][col] = cur++;            
        }
        return new Node(row - 1, col);
    }
    
    static Node up(int row, int col) {
        while(true) {
            if(!isCheck(row, col)) break;
            arr[row--][col--] = cur++;
        }
        return new Node(row + 1, col + 1);
    }
    
    static Node right(int row, int col) {
        while(true) {
            if(!isCheck(row, col)) break;
            arr[row][col++] = cur++;
        }
        return new Node(row, col - 1);
    } 
    
    static Node left(int row, int col) {
        while(true) {
            if(!isCheck(row, col)) break;
            arr[row][col--] = cur++;
        }
        return new Node(row, col + 1);
    }
}