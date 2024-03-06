/*
한 집하장에서 다른 집하장으로 이동하기 위해 가장 먼저 거쳐야 하는 집하장
경로 복원
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, INF = 10001;
	static int[][] arr, prev;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		prev = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i != j) arr[i][j] = INF;
			}
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			arr[from][to] = edge;
			arr[to][from] = edge;
			prev[from][to] = to;
			prev[to][from] = from;
		}

		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
						prev[i][j] = prev[i][k];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) sb.append("-");
				else sb.append(prev[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}