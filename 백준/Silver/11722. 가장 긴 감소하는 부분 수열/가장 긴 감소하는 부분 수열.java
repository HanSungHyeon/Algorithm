/*
가장 긴 감소하는 부분 수열을 구해야 함
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[n];
		int max = 0;
		//LDS
		for(int i = n - 1; i >= 0; i--) {
			dp[i] = 1;
			for(int j = n - 1; j > i; j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}