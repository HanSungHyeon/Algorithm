import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int node, line;
    public static boolean[] flag;
    public static int[][] arr;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        flag = new boolean[node + 1];

        //배열 초기화
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        System.out.println(dfs(1));
    }

    public static int dfs(int start) {
        flag[start] = true;

        for (int i = 1; i <= node; i++) {
            if (!flag[i] && arr[start][i] == 1) {
                result++;
                dfs(i);
            }
        }
        return result;
    }
}