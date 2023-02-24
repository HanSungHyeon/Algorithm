import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, ans1 = 0, ans2 = 0;
	static String[][] arr;
	static boolean[][] flag1,flag2;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		flag1 = new boolean[n][n];
		flag2 = new boolean[n][n];
		arr = new String[n][n];
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine().split("");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!flag1[i][j]) {
					bfs1(i, j, arr[i][j]);
					ans1++;
				}
					
				if(!flag2[i][j]) {
					bfs2(i, j, arr[i][j]);
					ans2++;
				}
					
			}
		}
		System.out.println(ans1 + " " + ans2);
	}

	public static void bfs1(int x, int y, String color) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		flag1[x][y] = true;

		while (!q.isEmpty()) {
			int tmpx = q.peek().x;
			int tmpy = q.peek().y;
			q.poll();

			for (int i = 0; i < delta.length; i++) {
				int dx = tmpx + delta[i][0];
				int dy = tmpy + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;

				if (!flag1[dx][dy] && arr[dx][dy].equals(color)) {
					flag1[dx][dy] = true;
					q.add(new Node(dx, dy));
				}
			}
		}
	}
	public static void bfs2(int x, int y, String color) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		flag2[x][y] = true;

		while (!q.isEmpty()) {
			int tmpx = q.peek().x;
			int tmpy = q.peek().y;
			q.poll();

			for (int i = 0; i < delta.length; i++) {
				int dx = tmpx + delta[i][0];
				int dy = tmpy + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;

				if (!flag2[dx][dy] && color.equals("B") && arr[dx][dy].equals("B")) {
					flag2[dx][dy] = true;
					q.add(new Node(dx, dy));
				}
				if (!flag2[dx][dy] && (color.equals("G") || color.equals("R")) && (arr[dx][dy].equals("R") || arr[dx][dy].equals("G"))) {
					flag2[dx][dy] = true;
					q.add(new Node(dx, dy));
				}
			}
		}
	}
}