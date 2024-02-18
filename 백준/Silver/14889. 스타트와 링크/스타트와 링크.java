import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		flag = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		c(1,n/2);
		System.out.println(ans);
	}

	// 점수 계산
	private static void score() {
		int a = 0;
		int b = 0;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (flag[i] && flag[j]) {
					a += arr[i][j] + arr[j][i];
				} else if (!flag[i] && !flag[j]) {
					b += arr[i][j] + arr[j][i];
				}
			}
		}
		ans = Math.min(ans, Math.abs(a - b));

	}

	// 조합
	private static void c(int start, int count) {
		if (count == 0) {
//			System.out.println(Arrays.toString(flag));
			score();
			return;
		}

		for (int i = start; i <= n; i++) {
			flag[i] = true;
			c(i + 1, count - 1);
			flag[i] = false;
		}
	}
}