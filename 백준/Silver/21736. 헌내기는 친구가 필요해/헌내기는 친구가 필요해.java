import java.io.*;
import java.util.*;

public class Main {
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String[][] map;
    static boolean[][] flag;
    static int x, y, n, m, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        flag = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("I")) {
                    x = i;
                    y = j;

                }
            }
        }
        dfs(x,y);
        if(ans == 0)
            System.out.println("TT");
        else
            System.out.println(ans);
    }

    //dfs 재귀
    public static void dfs(int x, int y) {
        flag[x][y] = true;

        for (int i = 0; i < delta.length; i++) {
            int r = delta[i][0] + x;
            int c = delta[i][1] + y;

            if (r < 0 || r >= n || c < 0 || c >= m || flag[r][c] || map[r][c].equals("X"))
                continue;
            
            if (map[r][c].equals("P")) {
                ans++;
                map[r][c] = "O";
            }
            dfs(r,c);
        }
    }
}