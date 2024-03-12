import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] - 1 == arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}