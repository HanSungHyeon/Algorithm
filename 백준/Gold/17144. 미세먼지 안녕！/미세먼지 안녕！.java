import java.io.*;
import java.util.*;

public class Main {
	static int r, c, t, ans = 0;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Dust> q = new LinkedList<>();
	static int[][] m = new int[2][2];

	static class Dust {
		int x, y, mount;

		public Dust(int x, int y, int mount) {
			this.x = x;
			this.y = y;
			this.mount = mount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		int idx = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;

				if (num == -1) {
					m[idx][0] = i;
					m[idx++][1] = j;
				}
			}
		}
		//print();
		for (int i = 0; i < t; i++)
			start();
		System.out.println(ans());
	}
	
	private static void print() {
		for(int i = 0 ; i < r;i++)
			System.out.println(Arrays.toString(arr[i]));
		System.out.println("----------------------------");
	}
	private static int ans() {
		int sum = 0;
		for(int i =0 ;i < r; i++)
			sum += Arrays.stream(arr[i]).sum();
		
		return sum + 2;
	}

	// 공기청정기 작동
	private static void start() {
		put();
		bfs();
		//print();
		uWind();
		arr[m[0][0]][1] = 0;
		dWind();
		arr[m[1][0]][1] = 0;
		//print();
	}

	// 위쪽 공기 바람 (반시계 방향)
	private static void uWind() {
		int x = m[0][0];
		int y = m[0][1];
		// 위 -> 아래
		for (int i = x - 1; i > 0; i--) {
			arr[i][0] = arr[i - 1][0];
		}
		// 오 -> 왼
		for (int i = 0; i <= c - 2; i++) {
			arr[0][i] = arr[0][i + 1];
		}
		// 아래 -> 위
		for (int i = 0; i < x; i++) {
			arr[i][c - 1] = arr[i + 1][c - 1];
		}
		// 왼 -> 오
		for (int i = c - 1; i > 1; i--) {
			arr[x][i] = arr[x][i - 1];
		}
	}

	// 아래 공기 바람 (시계 방향)
	private static void dWind() {
		int x = m[1][0];
		int y = m[1][1];
		// 아래 -> 위
		for (int i = x + 1; i <= r - 2; i++) {
			arr[i][0] = arr[i + 1][0];
		}
		// 오 -> 왼
		for (int i = 0; i <= c - 2; i++) {
			arr[r - 1][i] = arr[r - 1][i + 1];
		}
		// 위 -> 아래
		for (int i = r - 1; i > x; i--) {
			arr[i][c - 1] = arr[i - 1][c - 1];
		}
		// 왼 -> 오
		for (int i = c - 1; i > 1; i--) {
			arr[x][i] = arr[x][i - 1];
		}
	}

	// 먼지 확산
	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int mount = q.peek().mount;
			q.poll();
			int spread = mount / 5;
			for (int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= r || dy >= c || arr[dx][dy] == -1)
					continue;
				
				arr[x][y] -= spread;
				arr[dx][dy] += spread;
			}
		}
	}

	private static void put() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] > 0)
					q.add(new Dust(i, j, arr[i][j]));
			}
		}
	}
}