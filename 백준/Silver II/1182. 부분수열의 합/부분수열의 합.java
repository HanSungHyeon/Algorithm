//부분 수열의 합
//순조부 부

import java.io.*;
import java.util.*;

public class Main {
	static int n, s, count = 0;
	static int[] arr;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		flag = new boolean[n];
		subSet(0);

		if (s == 0) count--;
		System.out.println(count);
	}

	static void subSet(int num) {
		if (num == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (flag[i]) sum += arr[i];
			}
			if (sum == s) count++;
			return;
		}

		//고르고 다음거 체크
		flag[num] = true;
		subSet(num + 1);

		//안고르고 다음거 체크
		flag[num] = false;
		subSet(num + 1);
	}
}
