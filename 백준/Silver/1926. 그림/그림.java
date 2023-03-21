import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] flag;
	static int n, m,tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		flag = new boolean[n][m];

		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int ans = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!flag[i][j] && arr[i][j] == 1) {
					tmp = 0;
					ans = Math.max(ans, dfs(i, j));
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(ans);
	}

	private static int dfs(int x, int y) {
		flag[x][y] = true;
		tmp++;
		for (int i = 0; i < delta.length; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];

			if (dx < 0 || dy < 0 || dx >= n || dy >= m || flag[dx][dy])
				continue;

			if (arr[dx][dy] == 1)
				dfs(dx, dy);
		}
		return tmp;
	}
}