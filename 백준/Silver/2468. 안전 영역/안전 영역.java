import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] flag;
    static int max = 0, n;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        flag = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }
        int ans = 0;
        while(max-- > 0) {
            for(int i = 0; i < n; i++) Arrays.fill(flag[i], false);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] <= max) flag[i][j] = true;
                }
            }
            int count = 0;
            for(int i = 0 ; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!flag[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n || flag[x][y]) return;
        //방문 처리
        flag[x][y] = true;

        //상
        dfs(x - 1, y);

        //하
        dfs(x + 1, y);

        //좌
        dfs(x, y - 1);

        //우
        dfs(x, y + 1);
    }
}
