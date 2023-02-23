import java.io.*;
import java.util.*;

public class Main {
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[] flag;
	static String[][] arr;
	static List<String> words = new ArrayList<>();;
	static int r, c, ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		flag = new boolean[26];
		arr = new String[r][c];
		for (int i = 0; i < r; i++)
			arr[i] = br.readLine().split("");

		flag[arr[0][0].charAt(0) - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	public static void dfs(int x, int y, int count) {
		ans = Math.max(ans, count);
		for (int i = 0; i < delta.length; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];

			if (dx < 0 || dy < 0 || dx >= r || dy >= c)
				continue;

			if (!flag[arr[dx][dy].charAt(0) - 'A']) {
//				words.add(arr[dx][dy]);
				flag[arr[dx][dy].charAt(0) - 'A'] = true;
//				System.out.println(Arrays.toString(flag));
				dfs(dx, dy, count + 1);
				flag[arr[dx][dy].charAt(0) - 'A'] = false;
//				words.remove(words.size() - 1);
			}
		}
	}

	public static boolean isCheck(String word) {
		for (String s : words) {
			if (word.equals(s))
				return false;
		}
		return true;
	}
}