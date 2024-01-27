import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] flag;
    static int n;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            flag = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            int count = 0;
            for(int i = 1; i <= n; i++) {
                if(!flag[i]) {
                    dfs(i);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int num) {
        if(flag[num]) {
            return;
        }
        flag[num] = true;

        dfs(arr[num]);
    }
}
