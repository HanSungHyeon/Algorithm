import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            list = new ArrayList[n + 1];
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[end].add(from);
            }
            int target = Integer.parseInt(br.readLine());
            sb.append(dp(target)).append("\n");
        }
        System.out.println(sb);
    }

    static int dp(int num) {
        if(dp[num] > -1) return dp[num];

        int max = 0;
        for(int i : list[num]) {
            max = Math.max(dp(i), max);
        }
        return dp[num] = arr[num] + max;
    }
}
