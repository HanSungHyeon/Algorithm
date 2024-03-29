import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y, d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int n, m;
	static String[][] arr;
	static boolean[][] flag;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new String[n][m];

		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().split("");
		}

		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j].equals("W")) continue;
				flag = new boolean[n][m];
				ans = Math.max(bfs(i,j),ans);
			}
		}
		System.out.println(ans);
	}

	static int bfs(int sx, int sy) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, 0));
		flag[sx][sy] = true;
		int max = 0;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.peek().d;
			q.poll();
			max = Math.max(max, d);

			for(int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if(dx < 0 || dx >= n || dy < 0 || dy >= m || flag[dx][dy] || arr[dx][dy].equals("W")) continue;

				flag[dx][dy] = true;
				q.add(new Node(dx,dy, d + 1));
			}
		}
		return max;
	}
}