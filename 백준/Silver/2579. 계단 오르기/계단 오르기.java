/*
1. 규칙
 - 한 계단 또는 두 계단 오를 수 있음
  - 연속된 세 개의 계단을 밟으면 안됨 -> 시작점은 계단에 포함되지 않음
  - 마지막 계단은 무조건 밟아야함

현재 위치에서 다음꺼를 밟거나 다다음꺼를 발거나 택해야함
다음꺼를 밟으면 그 다음꺼는 자연스럽게 밟을 수 없음
->
 */

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];

		for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

		int ans = dp(n);
		System.out.println(ans);
	}

	static int dp(int num) {
		if(num == 1) return arr[num];

		if(num == 2) return arr[num] + arr[num - 1];

		//3이면 점프 + 1, 1 + 점프 중 하나 골라야 함
		if(num == 3) return Math.max(arr[1], arr[2]) + arr[3];

		if(dp[num] > 0) return dp[num];

		return dp[num] = Math.max(dp(num - 2), dp(num - 3) + arr[num - 1]) + arr[num];
	}
}
