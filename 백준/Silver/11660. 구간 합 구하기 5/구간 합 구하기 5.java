import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];
		for(int i = 1; i <= n; i++) {
			dp[1][i] = dp[1][i - 1] + arr[1][i];
			dp[i][1] = dp[i - 1][1] + arr[i][1];
		}
		sum(n,n);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sb.append(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]).append("\n");
		}
		System.out.println(sb);
	}
	
	//누적합 구하기
	static int sum(int x, int y) {
		if(x == 0 && y == 0) return dp[x][y];

		if(dp[x][y] > 0) return dp[x][y];

		return dp[x][y] = sum(x - 1, y) + sum(x, y - 1) + arr[x][y] - sum(x - 1, y - 1);
	}
}