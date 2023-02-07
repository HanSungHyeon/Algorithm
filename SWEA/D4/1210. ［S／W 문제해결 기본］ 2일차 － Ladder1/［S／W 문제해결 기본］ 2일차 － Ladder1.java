import java.io.*;
import java.util.*;
 
public class Solution {
    // up left right
    static int[][] delta = { { -1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] isCheck;
    static int result;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
 
            int[][] board = new int[100][100];
            isCheck = new boolean[100][100];
            int x = 0;
            int y = 0;
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }
            ladder(board, x, y);
            System.out.println("#" + t + " " + result);
        }
    }
 
    public static void ladder(int[][] board, int x, int y) {
        if (x == 0) {
            result = y;
            return; // y return
        }
 
        // left
 
        if (y - 1 >= 0 && board[x][y - 1] == 1 && !isCheck[x][y - 1]) {
            isCheck[x][y - 1] = true;
            ladder(board, x, y - 1);
        } else if (y + 1 < 100 && board[x][y + 1] == 1 && !isCheck[x][y + 1]) {
            isCheck[x][y + 1] = true;
            ladder(board, x, y + 1);
        } else if (x - 1 >= 0 && board[x - 1][y] == 1 && !isCheck[x - 1][y]) {
            isCheck[x - 1][y] = true;
            ladder(board, x - 1, y);
        }
    }
}