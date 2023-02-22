import java.io.*;
import java.util.*;

public class Solution {
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[] flag;
	static int[][] arr, result;
	static int n, min = Integer.MAX_VALUE, comx, comy, homex, homey;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			comx = Integer.parseInt(st.nextToken());
			comy = Integer.parseInt(st.nextToken());
			homex = Integer.parseInt(st.nextToken());
			homey = Integer.parseInt(st.nextToken());
			arr = new int[n][2];
			result = new int[n][2];
			flag = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			p(0);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}

	public static void p(int num) {
		if (num == n) {
			cal();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!flag[i]) {
				flag[i] = true;
				result[num][0] = arr[i][0];
				result[num][1] = arr[i][1];
				p(num + 1);
				flag[i] = false;
			}
		}
	}

	public static void cal() {
		int sum = 0;
		sum += Math.abs(comx - result[0][0]) + Math.abs(comy - result[0][1]);
		for (int i = 0; i < result.length - 1; i++) {
			sum += Math.abs(result[i][0] - result[i + 1][0]) + Math.abs(result[i][1] - result[i + 1][1]);
		}
		sum += Math.abs(result[n - 1][0] - homex) + Math.abs(result[n - 1][1] - homey);
		min = Math.min(min,sum);
	}
}