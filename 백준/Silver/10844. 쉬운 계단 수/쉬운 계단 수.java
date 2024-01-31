import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][10];
        for(int i = 0; i <= 9; i++) dp[1][i] = 1;

        long ans = 0;
        for(int i = 1; i <= 9; i++) ans += dp(n,i);
        System.out.println(ans % 1000000000);

    }

    static long dp(int n, int m){
        if(n == 0) return 0;

        if(dp[n][m] > 0) return dp[n][m];

        if(m == 0) return dp[n][m] = dp(n - 1, m  + 1) % 1000000000;

        if(m == 9) return dp[n][m] = dp(n - 1, m - 1) % 1000000000;

        return dp[n][m] = (dp(n - 1, m - 1) + dp(n - 1, m + 1)) % 1000000000;
    }
}
