import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] flag;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        flag = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++) {
                int edge = Integer.parseInt(st.nextToken());

                arr[i][j] = edge;
            }
        }

        //최단거리 구함
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <=n; i++) {
                for(int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        flag[m + 1] = true;
        dfs(m + 1, 0);
        System.out.println(ans);

    }
    public static boolean isCheck() {
        for(int i = 1; i <= n; i++) {
            if(!flag[i]) return false;
        }
        return true;
    }

    public static void dfs(int start, int sum) {
        if(isCheck()) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!flag[i]) {
                flag[i] = true;
                dfs(i, sum + arr[start][i]);
                flag[i] = false;
            }
        }
    }
}