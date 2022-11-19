import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int node, line, start;
	public static boolean[] flag;
	public static int[][] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		arr = new int[node + 1][node + 1];
		flag = new boolean[node + 1];

		// 배열 초기화
		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;
		}
		dfs(start);
		sb.append("\n");
		flag = new boolean[node + 1];
		bfs(start);
		System.out.println(sb);

	}

	public static void dfs(int start) {
		flag[start] = true;
		sb.append(start).append(" ");

		for (int i = 1; i <= node; i++) {
			if (!flag[i] && arr[start][i] == 1)
				dfs(i);
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		flag[start] = true;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			sb.append(temp).append(" ");

			for (int i = 1; i <= node; i++) { // 3
				if (!flag[i] && arr[temp][i] == 1) {
					queue.add(i);
					flag[i] = true;
				}
			}
		}
	}
}