import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int[] result;
	static boolean[] flag;
	static boolean[] pflag;
	static int[] presult;
	static List<Integer> list;
	static int sum = 0;
	static int ans = Integer.MAX_VALUE;

	// 팀 순열
	private static void p(int num) {
		if (num == 2) {
			sum += arr[presult[0]][presult[1]];
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!pflag[i]) {
				pflag[i] = true;
				presult[num] = list.get(i);
				p(num + 1);
				pflag[i] = false;
			}
		}
	}

	// 스타트 링크 팀 조합
	private static void c(int num, int start) {
		if (num == n / 2) {
			sum = 0;
			Arrays.fill(flag, false);
			presult = new int[2];
			
			for (int i : result)
				flag[i] = true;
			list = new ArrayList<>();

			for (int i = 1; i < flag.length; i++) {
				if (flag[i])
					list.add(i);
			}
			pflag = new boolean[list.size()];
			Arrays.fill(pflag, false);
			p(0);
			list = new ArrayList<>();
			Arrays.fill(pflag, false);
			int startT = sum;
			sum = 0;
			for (int i = 1; i < flag.length; i++) {
				if (!flag[i])
					list.add(i);
			}
			p(0);
			int linkT = sum;
			ans = Math.min(ans, Math.abs(startT - linkT));
			return;
		}

		for (int i = start; i <= n; i++) {
			result[num] = i;
			c(num + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		result = new int[n / 2];
		flag = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		c(0, 1);
		System.out.println(ans);

	}

}