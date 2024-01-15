import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r, INF = 100000000;
    static int[][] arr;
    static int[] item;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                if(i != j) arr[i][j] = INF;
            }
        }
        item = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        int tmp = st.countTokens();
        for(int i = 1; i <= tmp; i++) item[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            arr[from][to] = Math.min(arr[from][to], edge);
            arr[to][from] = Math.min(arr[to][from], edge);
        }

        //전체 최단 경로
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        //어디서 시작해야 가장 많은 아이템 먹을 수 있는지 판단
        //수색 범위 넘어가지 않는 범위 내에서
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] <= m) {
                    count += item[j];
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}
