import java.io.*;
import java.util.*;

public class Solution {
	static int[][] arr;
	static int n, ans;
	static int[] result;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1][n + 1];
			flag = new boolean[n + 1];
			result = new int[n / 2];
			ans = Integer.MAX_VALUE;

			for (int i = 1; i < n + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			c(0, 1);
			System.out.println("#" + t + " " +ans);
		}

	}

	private static void score() {
		int a = 0, b = 0;
		for (int i = 1; i < flag.length - 1; i++) {
			for (int j = i + 1; j < flag.length; j++) {
				if (flag[i] && flag[j]) {
					a += arr[i][j] + arr[j][i];
				}
				if (!flag[i] && !flag[j]) {
					b += arr[i][j] + arr[j][i];
				}
			}
		}
		ans = Math.min(ans, Math.abs(a - b));
	}

	private static void c(int num, int start) {
		if (num == n / 2) {
			Arrays.fill(flag, false);
			for (int i : result) {
				flag[i] = true;
			}
			score();
			return;
		}

		for (int i = start; i <= n; i++) {
			result[num] = i;
			c(num + 1, i + 1);
		}
	}
}