import java.io.*;
import java.util.*;

public class Main {
	static int n, mod = 9901;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i -1][1] + dp[i - 1][2]) % mod;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
		}
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);
	}
}