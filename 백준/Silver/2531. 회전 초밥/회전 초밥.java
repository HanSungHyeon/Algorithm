import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c, count, ans;
	static int[] arr, flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[n];
		flag = new int[d + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		count = 0;
		for (int i = 0; i < k; i++) {
			if (flag[arr[i]] == 0) count++;

			flag[arr[i]]++;
		}

		ans = count;
		if (flag[c] == 0) ans++;

		slide();
		System.out.println(ans);
	}

	//(i + k - 1) % n;
	static void slide() {
		for (int i = 1; i < n; i++) {
			int idx = (i + k - 1) % n;

			if (flag[arr[idx]] == 0) count++;
			flag[arr[idx]]++;

			flag[arr[i - 1]]--;
			if (flag[arr[i - 1]] == 0) count--;

			findMax();
		}
	}

	static void findMax() {
		if (ans <= count) {
			if (flag[c] == 0) ans++;
			else ans = count;
		}
	}
}
