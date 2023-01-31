import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m + 1];
		flag = new boolean[n + 1];

		recur(0);
		System.out.println(sb);
	}

	public static void recur(int num) {
		if (num == m) {
			for (int i = 0; i < m; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if ((num > 0 && arr[num - 1] <= i) || num == 0) {
				arr[num] = i;
				recur(num + 1);
			}
		}
	}

}