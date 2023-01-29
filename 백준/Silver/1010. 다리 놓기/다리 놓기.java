import java.io.*;
import java.util.*;

public class Main {
	public static long[][] dp = new long[30][30];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(function(Math.max(w, e), Math.min(w, e)) + "\n");
		}
		System.out.println(sb);
	}

	public static long function(int max, int min) {
		if (max == min || min == 0)
			return dp[max][min] = 1;

		if (dp[max][min] > 0)
			return dp[max][min];

		return dp[max][min] = function(max - 1, min - 1) + function(max - 1, min);
	}
}