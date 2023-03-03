import java.io.*;
import java.util.*;

public class Main {
	static int m, n, day;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Tomato {
		int x, y, d;

		public Tomato(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static Queue<Tomato> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if (num == 1) {
					q.add(new Tomato(i, j, 0));
					tmp++;
				}
			}
		}
		
		if(tmp == m * n) System.out.println(0);
		else {
			bfs();
			if(isCheck()) System.out.println(day);
			else System.out.println(-1);
		}
	}
	private static boolean isCheck() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.peek().d;
			q.poll();
			day = d;
			//System.out.println(day);
			for (int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;

				if (arr[dx][dy] == 0) {
					q.add(new Tomato(dx, dy,d + 1));
					arr[dx][dy] = 1;
				}
			}
		}
	}
}