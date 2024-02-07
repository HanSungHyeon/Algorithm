import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, k;
	static int[][] arr, delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean[][] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			arr = new int[n][m];
			flag = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!flag[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y) {

		flag[x][y] = true;

		for (int i = 0; i < delta.length; i++) {
			int dx = delta[i][0] + x;
			int dy = delta[i][1] + y;

			if (dx < 0 || dx >= n || dy < 0 || dy >= m || flag[dx][dy] || arr[dx][dy] != 1) continue;

			dfs(dx, dy);
		}
	}
}