import java.io.*;
import java.util.*;

public class Main {
	public static long[][] dp = new long[1007][1007];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(function(n, k));
	}

	public static long function(int n, int k) {
		if (n == k || k == 0)
			return dp[n][k] = 1;

		if (dp[n][k] > 0)
			return dp[n][k];

		return dp[n][k] = (function(n - 1, k - 1) + function(n - 1, k)) % 10007;
	}
}