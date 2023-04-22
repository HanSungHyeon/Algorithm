import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		int INF = 10000000;

		// 배열 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					arr[i][j] = INF;
			}
		}

		/*
		 * from ~ to의 경로가 하나가 아닐 수 있음 최단거리를 구해야하기 때문에 여러 경로중 가장 작은 값을 넣어줌
		 */
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int edge = Integer.parseInt(st.nextToken());

			arr[from][to] = Math.min(arr[from][to], edge);
		}

		// 경유지 출발지 도착지
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// (출발지 ~ 경유지) + (경유지 ~ 출발지)
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == INF) arr[i][j] = 0;
				
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}