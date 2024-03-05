import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y, count;
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	static int m,n, INF = Integer.MAX_VALUE;
	static int[][] arr,wall, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		wall = new int[n][m];
		for(int i = 0; i < n; i++) arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				wall[i][j] = INF;
			}
		}
		wall[0][0] = 0;
		dijkstra();
		System.out.println(wall[n - 1][m - 1]);
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		pq.add(new Node(0,0,0));

		while(!pq.isEmpty()) {
			int x = pq.peek().x;
			int y = pq.peek().y;
			int count = pq.peek().count;
			pq.poll();

			if(wall[x][y] != count) continue;

			for(int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if(dx < 0 || dx >= n || dy < 0 || dy >= m) continue;

				if(wall[dx][dy] > arr[dx][dy] + wall[x][y]) {
					wall[dx][dy] = arr[dx][dy] + wall[x][y];
					pq.add(new Node(dx,dy,wall[dx][dy]));
				}
			}
		}
	}
}