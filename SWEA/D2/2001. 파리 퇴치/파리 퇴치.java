import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = 0;
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] dp = new int[n + 1][n + 1];

			for (int i = 1; i < dp.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < dp.length; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i <= dp.length - m; i++) {
				for (int j = 1; j <= dp.length - m; j++) {
					result = Math.max(result,
							dp[i + m - 1][j + m - 1] - dp[i + m - 1][j - 1] - dp[i - 1][j + m - 1] + dp[i - 1][j - 1]);
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}