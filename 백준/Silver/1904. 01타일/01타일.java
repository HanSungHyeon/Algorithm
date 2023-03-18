import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n +1];
		
		System.out.println(dp(n));
	}
	
	private static int dp(int num) {
		if(num == 1) return 1 % 15746;
		
		if(num == 2) return 2 % 15746;
		
		if(num == 3) return 3 % 15746;
		
		if(dp[num] > 0) return dp[num];
		
		return dp[num] = (dp(num - 1) + dp(num - 2)) % 15746;
	}

}