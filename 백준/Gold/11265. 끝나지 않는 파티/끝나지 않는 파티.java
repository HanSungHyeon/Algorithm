import java.io.*;
import java.util.*;

public class Main {
	static int INF = 2000000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dist = new int[n][n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken());

			if(dist[from][to] <= time) sb.append("Enjoy other party");
			else sb.append("Stay here");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}