import java.io.*;
import java.util.*;

public class Solution {
	static int n, m;
	static int[] snack, arr;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			result = -1;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			snack = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			arr = new int[2];
			c(0,0);
			System.out.println("#" + i + " " + result);
		}

	}

	public static void c(int num, int start) {
		if (num == 2) {
			int tmp = Arrays.stream(arr).sum();
			if (tmp <= m)
				result = Math.max(result, tmp);
			return;
		}

		for (int i = start; i < n; i++) {
			arr[num] = snack[i];
			c(num + 1, i + 1);
		}
	}

}