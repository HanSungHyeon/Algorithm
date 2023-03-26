import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n][3];

		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		dp(n - 1,0);
		dp(n - 1,1);
		dp(n - 1,2);
		
		int ans = Arrays.stream(dp[n - 1]).min().getAsInt();
		
		System.out.println(ans);
		
		
	}

	private static int dp(int depth, int rgb) {
		//배열 바닥까지 내려왔을 때
		if(depth == 0) {
			if(rgb == 0) return arr[depth][0];
			else if(rgb ==1) return arr[depth][1];
			else return arr[depth][2];
		}
		
		if(dp[depth][rgb] != 0) return dp[depth][rgb];
		
		if(rgb == 0)
			return dp[depth][0] = arr[depth][0] + Math.min(dp(depth - 1,1),dp(depth - 1, 2));
		else if(rgb == 1)
			return dp[depth][1] = arr[depth][1] + Math.min(dp(depth - 1,0),dp(depth - 1, 2));
		else
			return dp[depth][2] = arr[depth][2] + Math.min(dp(depth - 1,0),dp(depth - 1, 1));
	}
}