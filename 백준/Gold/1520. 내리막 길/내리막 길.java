/*
*dfs + dp
* */

import java.io.*;
import java.util.*;

public class Main {
	static int m,n;
	static int[][] arr, dp;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		dp = new int[m][n];

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		int ans = dfs(0,0);

		System.out.println(ans);
	}

	static int dfs(int x, int y) {
		if(x == m - 1 && y == n - 1) return 1;

		//이미 방문했으면
		if(dp[x][y] != -1) return dp[x][y];

		//방문 처리
		dp[x][y] = 0;

		for(int i = 0; i < delta.length; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];

			if(dx < 0 || dx >= m || dy < 0 || dy >= n || arr[x][y] <= arr[dx][dy]) continue;

			dp[x][y] += dfs(dx, dy);
		}
		return dp[x][y];
	}
}