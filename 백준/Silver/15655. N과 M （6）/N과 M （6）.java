import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] pick, arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pick = new int[m];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

		c(0, 0);
		System.out.println(sb);
	}

	static void c(int start, int count) {
		if (count == m) {
			for (int i : pick) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < n; i++) {
			pick[count] = arr[i];
			c(i + 1, count + 1);

		}
	}
}