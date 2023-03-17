import java.io.*;
import java.util.*;

public class Main {
	static int[] dp = new int[12];
	
	private static int dp(int num) {
		if(num == 1) return dp[num];
		
		if(num == 2) return dp[num];
		
		if(num == 3) return dp[num];
		
		if(dp[num] > 0) return dp[num];
		
		return dp[num] = dp(num -1) + dp(num - 2) + dp(num - 3);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp(num) + "\n");
		}
		System.out.println(sb);
	}
}