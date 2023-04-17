import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split("");
		String[] b = br.readLine().split("");
		
		//2차원 배열 생성
		int[][] dp = new int[a.length + 1][b.length + 1];
		
		for(int i = 1; i <= a.length; i++) {
			for(int j = 1; j <= b.length; j++) {
				//해당 문자가 같을 때
				//좌상단 값 + 1
				if(a[i - 1].equals(b[j - 1]))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				
				//같지 않으면
				//이전에 기록 된 값 중에 가장 큰 놈을 가져옴
				else dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
			}
		}		
		System.out.println(dp[a.length][b.length]);		
	}
}