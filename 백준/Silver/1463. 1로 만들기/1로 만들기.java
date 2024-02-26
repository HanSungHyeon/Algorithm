/*
x % 3 == 0 -> 3으로 나눔
x % 2 == 0 -> 2로 나눔
x--;

3가지 경우를 적절하게 사용해서
1을 만들려고 함
연산을 사용하는 횟수의 최소값 출력
1000000
완탐 -> n^3 -> 시간 초과
시간 제한 : 0.15초
2 to 1을 위해서는 최소 m회가 필요할거고~
3 to 1을 위해서는 최소 m회가 필요할거고~
n을 연산하다보면은 2, 3처럼 이미 계산 결과가 있는 애들이 있을거고~
이미 계산 결과가 있으면 걍 그거 땡겨오면됨
-> 굳이 2,3,...결과가 있는데 또 연산하러 갈 필요가 없음 -> dp
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, INF = Integer.MAX_VALUE;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		System.out.println(dp(n));

	}
	static int dp(int num) {
		if(num == 1) return 0;
		if(num == 2 || num == 3) return 1;

		//이미 연산한 적이 있으면?
		if(dp[num] > 0) return dp[num];

		//3가지 경우
		int tmp3 = INF, tmp2 = INF, tmp1 = INF;
		//3으로 나누어 떨어질 때
		if(num % 3 == 0) tmp3 = dp(num / 3);

		//2로 나누어 떨어질 때
		if(num % 2 == 0) tmp2 = dp(num / 2);

		//1을 뺄 때
		tmp1 = dp(num - 1);

		//3개중 최소값 구하기
		int ans = Math.min(tmp1, Math.min(tmp3, tmp2));
		
		//연산 한 번 추가 됨
		return dp[num] = ans + 1;
	}
}
