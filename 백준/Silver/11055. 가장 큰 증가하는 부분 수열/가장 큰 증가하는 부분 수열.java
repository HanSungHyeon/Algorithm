import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[n];

		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(arr[i] + dp[j], dp[i]);
				}
				
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}