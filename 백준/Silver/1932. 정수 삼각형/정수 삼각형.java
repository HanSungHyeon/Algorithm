import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dp = new int[n + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int idx = 1;

			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				dp[i][idx] = num + Math.max(dp[i - 1][idx], dp[i - 1][idx - 1]);

				max = Math.max(dp[i][idx], max);
				idx++;
			}
		}
		System.out.println(max);
	}
}