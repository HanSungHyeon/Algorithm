import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int result = 0;
    static int[][] delta = {{1, 0}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

          int[][] board = new int[n][n];

        nQueen(0,board);
        System.out.println(result);
    }

    public static void nQueen(int depth,int[][] board) {
        if(depth == n){
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(board[depth][i] == 0){
                checkO(depth,i,board);
                nQueen(depth + 1,board);
                checkX(depth,i,board);
            }
        }
    }
    public static void checkO(int depth, int x,int[][] board){
        board[depth][x]++;
        for (int i = 0; i < delta.length; i++) {
            for (int j = 1; j <= n; j++) {
                int dx = x + delta[i][1] * j;
                int dy = depth + delta[i][0] * j;

                if(dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
                board[dy][dx]++;
            }
        }
    }

    public static void checkX(int depth, int x, int[][] board) {
        board[depth][x]--;
        for (int i = 0; i < delta.length; i++) {
            for (int j = 1; j <= n; j++) {
                int dx = x + delta[i][1] * j;
                int dy = depth + delta[i][0] * j;

                if(dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
                board[dy][dx]--;
            }
        }
    }
}