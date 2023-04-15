import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			// 알아보기 쉽게 같은 사이즈 배열 생성
			// +1인 이유 0 인덱스 자리를 비우기 위함
			arr = new int[2][n + 1];
			dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int i = 2; i <= n; i++) {
				// 윗줄 채우기
				// 좌측 하단, 좌측 하단에서 한 칸 왼쪽
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];

				// 아래 채우기
				// 좌측 상단, 좌측 상단에서 한 칸 왼쪽
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
			}
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb);
	}
}
